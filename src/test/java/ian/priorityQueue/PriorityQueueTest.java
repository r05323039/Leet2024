package ian.priorityQueue;

import ian.queue.Queue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void test() {
        PriorityQueue1<Priority> sut = new PriorityQueue1<>(5);
        runTest(sut);
    }

    @Test
    void test2() {
        PriorityQueue2<Priority> sut = new PriorityQueue2<>(5);
        runTest(sut);
    }

    @Test
    void test3() {
        MaxHeap<Priority> sut = new MaxHeap<>(5);
        runTest(sut);
    }

    private <T extends Priority> void runTest(Queue<T> sut) {
        sut.offer((T) new Entry("task1", 4));
        sut.offer((T) new Entry("task2", 3));
        sut.offer((T) new Entry("task3", 2));
        sut.offer((T) new Entry("task4", 5));
        sut.offer((T) new Entry("task5", 1));
        assertFalse(sut.offer((T) new Entry("task6", 7)));
        List<Integer> actuals = new ArrayList<>();
        while (!sut.isEmpty()) {
            actuals.add(sut.poll().priority());
        }
        assertIterableEquals(List.of(5, 4, 3, 2, 1), actuals);
    }
}