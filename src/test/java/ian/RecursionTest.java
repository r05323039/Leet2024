package ian;

import org.junit.jupiter.api.Test;

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
}