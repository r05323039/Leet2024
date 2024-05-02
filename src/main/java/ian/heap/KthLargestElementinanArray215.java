package ian.heap;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(4);

        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums);
        int result = -1;
        for (int i = 1; i <= k; i++) {
            result = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KthLargestElementinanArray215 o = new KthLargestElementinanArray215();

        assertEquals(5, o.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

        assertEquals(4, o.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));


        assertEquals(5, o.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));

        assertEquals(4, o.findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
