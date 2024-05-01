package ian.blockQueue;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeQueue {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition tailWaits = lock.newCondition();//集合:儲存阻塞thread

    public void offer(String e) throws InterruptedException {
        lock.lockInterruptibly();// 可在阻塞被喚醒
        try {
            while (isFull()) {//每次被喚醒要重新檢查條件
                tailWaits.await();//當前Thread加入此集合，並阻塞
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
        } finally {//確保出例外，也要解鎖
            lock.unlock();
        }
    }

    public String poll() {
        String polled = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = null;
        size--;
        if (--tail < 0) {
            tail = array.length - 1;
        }
        return polled;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeQueue queue = new UnsafeQueue();
        for (int i = 0; i < 10; i++) {
            queue.offer("e" + i);
        }

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " before offer");
                queue.offer("e10");
                System.out.println(Thread.currentThread().getName() + " after offer");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        new Thread(() -> {
            System.out.println("開始喚醒");
            try {
                queue.lock.lockInterruptibly();
                System.out.println("poll :" + queue.poll());
                queue.tailWaits.signal();//先lock才能喚醒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                queue.lock.unlock();//這裡unlock,signal才生效
            }
        }, "t2").start();
    }
}
