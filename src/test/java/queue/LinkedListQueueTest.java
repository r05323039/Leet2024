package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    private LinkedListQueue<Object> sut;

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
    }

    @Test
    void peek() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void iterator() {
    }

    @Test
    void forEach() {
    }

    @Test
    void spliterator() {
    }
}