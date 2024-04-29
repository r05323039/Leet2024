package ian.stack;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ImplementStackUsingQueues225 {
    static class MyStack {

        private LinkedList<Integer> queue1 = new LinkedList<>();
        private LinkedList<Integer> queue2 = new LinkedList<>();

        public void push(int x) {
            if (!queue1.isEmpty()) {
                queue1.offer(x);
            } else {
                queue2.offer(x);
            }
        }

        public int pop() {
            LinkedList<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;
            LinkedList<Integer> notEmptyQueue = queue1.isEmpty() ? queue2 : queue1;

            while (notEmptyQueue.size() > 1) {
                emptyQueue.offer(notEmptyQueue.poll());
            }
            return notEmptyQueue.poll();
        }

        public int top() {
            LinkedList<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;
            LinkedList<Integer> notEmptyQueue = queue1.isEmpty() ? queue2 : queue1;

            while (notEmptyQueue.size() > 1) {
                emptyQueue.offer(notEmptyQueue.poll());
            }

            Integer peek = notEmptyQueue.peek();
            while (notEmptyQueue.size() > 0) {
                emptyQueue.offer(notEmptyQueue.poll());
            }
            return peek;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        assertFalse(myStack.empty());
    }
}
