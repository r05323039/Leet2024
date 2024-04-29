package ian.deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    private int head;
    private int tail;
    private E[] array;

    public ArrayDeque(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    private int increase(int i) {
        return (i + 1) % array.length;
    }

    private int decrease(int i) {
        return i - 1 < 0 ? array.length - 1 : i - 1;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        head = decrease(this.head);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        array[tail] = e;
        tail = increase(tail);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }

        E polled = array[head];
        array[head] = null;
        head = increase(head);
        return polled;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = decrease(tail);
        E polled = array[tail];
        array[tail] = null;
        return polled;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[decrease(tail)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p];
                p = increase(p);
                return e;
            }
        };
    }
}
