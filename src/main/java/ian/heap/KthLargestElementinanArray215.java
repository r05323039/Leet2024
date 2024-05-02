package ian.heap;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(nums);
        int result = -1;
        for (int i = 1; i <= k; i++) {
            result = maxHeap.poll();
        }

        return result;
    }


    public static void main(String[] args) {
        KthLargestElementinanArray215 o = new KthLargestElementinanArray215();

        assertEquals(5, o.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

        assertEquals(4, o.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
