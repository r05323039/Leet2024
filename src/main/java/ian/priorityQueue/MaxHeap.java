package ian.priorityQueue;

import ian.queue.Queue;

public class MaxHeap<E extends Priority> implements Queue<E> {

    E[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = (E[]) new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {// O(log(n)) offer,poll 比較的元素都變少了
        if (isFull()) {
            return false;
        }
        int child = size;
        int parent = getParent(child);
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = getParent(child);
        }
        array[child] = value;
        size++;
        return true;
    }

    private int getParent(int child) {
        return (child - 1) / 2;
    }

    @Override
    public E poll() {// O(log(n))
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        Priority polled = array[size];
        array[size] = null;

        siftDown(0);

        return (E) polled;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    private void swap(int a, int b) {
        E e = array[a];
        array[a] = array[b];
        array[b] = e;
    }

    private void siftDown(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) {
            swap(parent, max);
            siftDown(max);
        }
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
