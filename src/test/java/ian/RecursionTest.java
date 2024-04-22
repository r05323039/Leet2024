package ian;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {
    private final Recursion sut = new Recursion();

    @Test
    void factorial() {
        assertEquals(6, sut.factorial(3));
        assertEquals(24, sut.factorial(4));
    }

    @Test
    void reversePrint() {
        sut.reversePrint("12345");
    }

    @Test
    void sort() {
        int[] nums = {5, 2, 1, 3, 4};
        sut.sort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    void fibonacci() {
        assertEquals(1, sut.fibonacci(1));
        assertEquals(1, sut.fibonacci(2));
        assertEquals(2, sut.fibonacci(3));
        assertEquals(3, sut.fibonacci(4));
        assertEquals(5, sut.fibonacci(5));
        assertEquals(8, sut.fibonacci(6));
    }
}