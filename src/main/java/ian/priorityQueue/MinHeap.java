package ian.priorityQueue;

import ian.ListNode;
import ian.queue.Queue;

public class MinHeap implements Queue<ListNode> {
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    @Override
    public boolean offer(ListNode value) {//小頂堆的offer可以確保小至大排序
        if (isFull()) {
            return false;
        }
        int child = size;
        int parent = getParent(child);
        while (child > 0 && value.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = getParent(child);
        }
        array[child] = value;
        size++;
        return true;
    }

    @Override
    public ListNode poll() {//每次poll都是最小的
        if (isEmpty()) {
            return null;
        }
        size--;
        swap(0, size);
        ListNode listNode = array[size];
        array[size] = null;

        siftDown(0);

        return listNode;
    }

    private void swap(int a, int b) {
        ListNode e = array[a];
        array[a] = array[b];
        array[b] = e;
    }

    private void siftDown(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {
            swap(parent, min);
            siftDown(min);
        }
    }

    @Override
    public ListNode peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    private int getParent(int child) {
        return (child - 1) / 2;
    }
}
