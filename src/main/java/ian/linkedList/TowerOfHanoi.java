package ian.linkedList;

import java.util.LinkedList;

class TowerOfHanoi {
    private static LinkedList<Integer> a = new LinkedList<>();
    private static LinkedList<Integer> b = new LinkedList<>();
    private static LinkedList<Integer> c = new LinkedList<>();

    private static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
        print();
    }

    private static void move(int n, LinkedList<Integer> start, LinkedList<Integer> transition, LinkedList<Integer> end) {
        if (n == 0) {
            return;
        }
        // 1. n-1 left -> middle
        move(n - 1, start, end, transition);
        // 2. 最大的 -> right
        end.addLast(start.removeLast());
        print();
        // 3. n-1 middle -> right
        move((n - 1), transition, start, end);
    }

    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("__________________");
    }

    public static void main(String[] args) {
        init(3);
        move(3, a, b, c);
    }
}
