package ian.priorityQueue;

import ian.queue.Queue;

public class PriorityQueue3<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        this.array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size;
        int parent = getParent(child);
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        size++;
        return true;
    }

    private int getParent(int child) {
        return (child - 1) / 2;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E max = (E) array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;

        int index = 0;
        int left = index * 2 + 1;
        int right = left + 1;
        E maxx = (E) array[index];


        return max;
    }

    private void swap(int a, int b) {
        Priority temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void dive(int i) {
        Priority left = array[2 * i + 1];
        Priority right = array[2 * i + 2];
        
    }

    @Override
    public E peek() {
        return null;
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
