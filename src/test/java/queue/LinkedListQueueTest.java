package queue;

import ian.queue.LinkedListQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    private LinkedListQueue<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListQueue<>();
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
        LinkedListQueue<Object> queue = new LinkedListQueue<>(2);
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertFalse(queue.offer(3));
    }

    @Test
    void iterator() {
        sut.offer(1);
        sut.offer(2);
        sut.offer(3);
        int expected = 1;
        for (int o : sut) {
            assertEquals(expected++, o);
        }
    }
}