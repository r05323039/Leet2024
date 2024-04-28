package ian.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private ArrayStack<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new ArrayStack<>(3);
    }

    @Test
    void push() {
        assertTrue(sut.push(1));
        assertTrue(sut.push(2));
        assertTrue(sut.push(3));
        assertFalse(sut.push(4));
        assertIterableEquals(List.of(3, 2, 1), sut);
    }

    @Test
    void pop() {
        sut.push(1);
        assertEquals(1, sut.pop());
        assertNull(sut.pop());
    }

    @Test
    void peek() {
        assertNull(sut.peek());
        sut.push(1);
        assertEquals(1, sut.peek());
        sut.push(2);
        assertEquals(2, sut.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(sut.isEmpty());
        assertTrue(sut.push(1));
        assertFalse(sut.isEmpty());
    }

    @Test
    void isFull() {
        assertTrue(sut.push(1));
        assertTrue(sut.push(2));
        assertFalse(sut.isFull());
        assertTrue(sut.push(3));
        assertTrue(sut.isFull());
    }

    @Test
    void iterator() {
        sut.push(1);
        sut.push(2);
        sut.push(3);
        int expected = 3;
        for (Integer i : sut) {
            assertEquals(expected--, i);
        }
    }
}