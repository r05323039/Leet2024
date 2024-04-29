package ian.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {
    static class MyQueue {
        private Stack<Integer> out = new Stack<>();
        private Stack<Integer> in = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();

        }

        public int peek() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return out.empty() && in.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
