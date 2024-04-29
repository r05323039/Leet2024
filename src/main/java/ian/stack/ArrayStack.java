package ian.stack;

import java.util.Iterator;

class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private E[] array;
    private int head = 0;

    public ArrayStack(int capacity) {
        this.array = ((E[]) new Object[capacity]);
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[head++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--head];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == 0;
    }

    @Override
    public boolean isFull() {
        return head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int p = head;

            @Override
            public boolean hasNext() {
                return p != 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
