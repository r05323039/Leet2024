package ian.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListDequeTest {
    private LinkedListDeque<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListDeque(5);
    }

    @Test
    void test() {
        sut.offerFirst(1);
        sut.offerFirst(2);
        sut.offerFirst(3);
        sut.offerLast(4);
        sut.offerLast(5);
        assertFalse(sut.offerFirst(6));
        assertIterableEquals(List.of(3, 2, 1, 4, 5), sut);

        assertEquals(3,sut.peekFirst());
        assertEquals(5,sut.peekLast());
        sut.pollFirst();
        sut.pollLast();

        assertIterableEquals(List.of(2,1,4),sut);

        for (Integer i : sut) {
            System.out.println(i);
        }
    }
}