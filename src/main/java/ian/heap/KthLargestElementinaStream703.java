package ian.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementinaStream703 {

    private final MinHeap heap;

    public KthLargestElementinaStream703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementinaStream703 o = new KthLargestElementinaStream703(3, new int[]{4, 5, 8, 2});
        assertEquals(4, o.add(3));
        assertEquals(5, o.add(5));
        assertEquals(5, o.add(10));
        assertEquals(8, o.add(9));
        assertEquals(8, o.add(4));

        KthLargestElementinaStream703 i = new KthLargestElementinaStream703(1, new int[]{});
        assertEquals(-3, i.add(-3));
        assertEquals(-2, i.add(-2));
        assertEquals(-2, i.add(-4));
        assertEquals(0, i.add(0));
        assertEquals(4, i.add(4));
    }
}
