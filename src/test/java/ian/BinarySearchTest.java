package ian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    private final BinarySearch sut = new BinarySearch();

    public void testBasic() {
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