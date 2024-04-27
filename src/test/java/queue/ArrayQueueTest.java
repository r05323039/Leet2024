package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new ArrayQueue<>(4);
    }

    @Test
    void offer() {
        sut.offer(1);
        sut.offer(2);
        sut.offer(3);
        assertIterableEquals(List.of(1, 2, 3), sut);
    }

    @Test
    void poll() {
        sut.offer(1);
        sut.offer(2);
        assertEquals(1, sut.poll());
        assertEquals(2, sut.poll());
        assertEquals(null, sut.poll());
    }

    @Test
    void peek() {
        sut.offer(1);
        assertEquals(1, sut.peek());
        sut.offer(2);
        assertEquals(1, sut.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(sut.isEmpty());

        sut.offer(1);

        assertFalse(sut.isEmpty());
    }

    @Test
    void isFull() {
        assertFalse(sut.isFull());
        sut.offer(1);
        sut.offer(1);
        sut.offer(1);
        sut.offer(1);
        assertTrue(sut.isFull());
    }

    @Test
    void iterator() {
        sut.offer(1);
        sut.offer(2);
        sut.offer(3);
        int expected = 1;
        for (Object o : sut) {
            assertEquals(expected++, o);
        }
    }
}