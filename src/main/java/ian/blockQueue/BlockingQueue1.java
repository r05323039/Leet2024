package ian.blockQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<E> implements BlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger();//代替int, 使thread安全，避免poll,offer同時修改size
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int c;//size添加前個數
        tailLock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            tail = ++tail == array.length ? 0 : tail;

            c = size.getAndIncrement(); //size++ 保證自增thread安全
            if (c + 1 < array.length) {
                tailWaits.signal();//如果還有空間可以offer，喚醒其他offer thread
            }
        } finally {
            tailLock.unlock();
        }

        if (c == 0) {//數量0時，poll 不能喚醒自己， 只能由offer喚醒poll
            try {
                headLock.lock();//拿到對應的lock才能使用condition的signal
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        int c;
        long t = TimeUnit.MILLISECONDS.toNanos(timeout);
        headLock.lockInterruptibly();
        try {
            while (isFull()) {
                if (t <= 0) {
                    return false;
                }
                t = tailWaits.awaitNanos(t);//返回的t為等待的剩餘時間
            }
            array[tail] = e;
            tail = ++tail == array.length ? 0 : tail;
            c = size.getAndIncrement();
            if (c + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            headLock.unlock();
        }
        if (c == 0) {
            try {
                headLock.lock();//拿到對應的lock才能使用condition的signal
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c; // 取走前的個數
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }

            e = array[head];
            array[head] = null;
            head = ++head == array.length ? 0 : head;

            c = size.getAndDecrement();
            if (c > 1) {//如果還有剩，喚醒其他poll thread繼續拿
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }
        if (c == array.length) {//原本是滿的，才喚醒
            try {
                tailLock.lock();
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue1<>(3);
        new Thread(() -> {
            try {
                queue.offer("e1");
                System.out.println(queue);
                queue.offer("e2");
                System.out.println(queue);
                queue.offer("e3");
                System.out.println(queue);
                queue.offer("e4", 5000);
                System.out.println(queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        Thread.sleep(1000);
        queue.poll();
        System.out.println(queue);
    }
}
