package ian.priorityQueue;

import ian.queue.Queue;

public class PriorityQueue1<E extends Priority> implements Queue<E> {

    private E[] array;
    private int size;

    public PriorityQueue1(int capacity) {
        array = (E[]) new Priority[capacity];
    }

    @Override
    public boolean offer(E value) { //O(1)
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        return true;
    }

    @Override
    public E poll() { //O(n)
        if (isEmpty()) {
            return null;
        }
        int i = findTopPriorityIndex();
        E polled = array[i];
        remove(i);
        return polled;
    }

    private void remove(int index) {
        if (index != size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        array[--size] = null;
    }

    private int findTopPriorityIndex() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[findTopPriorityIndex()];
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
