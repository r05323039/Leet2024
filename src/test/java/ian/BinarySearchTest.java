package ian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    private final BinarySearch sut = new BinarySearch();

    @Test
    public void testBasic() {
        assertEquals(4, sut.basic(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, sut.basic(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    public void basicRecursion() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(4, sut.basicRecursion(nums, 9));
        assertEquals(-1, sut.basicRecursion(nums, 2));
    }

    public void testSearchInsert() {
    }

    @Test
    public void testSearchRange() {
        assertArrayEquals(new int[]{3, 4}, sut.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, sut.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, sut.searchRange(new int[]{}, 0));
    }
}