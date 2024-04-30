package ian.priorityQueue;

import ian.queue.Quene;

public class PriorityQueue2<E extends Priority> implements Quene<E> {

    private E[] array;
    private int size;

    public PriorityQueue2(int capacity) {
        array = (E[]) new Priority[capacity];
    }

    @Override
    public boolean offer(E value) { //O(n)
        if (isFull()) {
            return false;
        }
        insert(value);
        return true;
    }

    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && value.priority() < array[i].priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
        size++;
    }

    @Override
    public E poll() { //O(1)
        if (isEmpty()) {
            return null;
        }
        E polled = array[--size];
        array[size] = null;
        return polled;
    }


    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
