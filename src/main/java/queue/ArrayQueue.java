package queue;


import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayQueue<E> implements Quene<E>, Iterable<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;


    @Override
    public boolean offer(E value) {
        return true;
    }

    @Override
    public E poll() {

        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}
