package ian.heap;

import java.util.Arrays;

public class MaxHeap {
    int array[];
    int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    private void heapify() {
        // 找到最後一個非葉節點 最後一個的parent  (size/2)-1 ，以上所有節點dive一次
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        if (max != parent) {
            swap(max, parent);
            siftDown(max);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
