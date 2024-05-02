package ian.heap;

import java.util.Arrays;

public class MinHeap {
    int array[];
    int size;

    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    public MinHeap(int[] array) {
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
        int min = parent;
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }

        if (min != parent) {
            swap(min, parent);
            siftDown(min);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int peek() {
        return array[0];
    }

    public int poll() {
        return poll(0);
    }

    public int poll(int index) {
        int polled = array[index];
        swap(index, size - 1);
        size--;//基本型別不用指向null，size--就指不到了
        siftDown(index);
        return polled;
    }

    public void replace(int value) {
        array[0] = value;
        siftDown(0);
    }

    public boolean offer(int value) {
        if (size == array.length) {
            int[] newInt = new int[array.length + 1];
            System.arraycopy(array, 0, newInt, 0, array.length);
            array = newInt;
        }

        up(value);
        size++;
        return true;
    }

    private void up(int value) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (array[parent] > value) {
                array[child] = array[parent];
                child = parent;
            } else {
                break;
            }
        }
        array[child] = value;
    }

    private void order() {
        while (size > 1) {
            swap(0, size - 1);
            size--;
            siftDown(0);
        }
        size = array.length;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(new int[]{6, 2, 7, 4, 3, 1, 5});
        System.out.println(Arrays.toString(heap.array));

        heap.offer(9);
        System.out.println(Arrays.toString(heap.array));

        heap.order();
        System.out.println(Arrays.toString(heap.array));
    }
}
