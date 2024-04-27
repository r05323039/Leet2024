package ian.linkedList;

import ian.linkedList.ListNode;

public class removeNthFromEnd19 extends ListNode {
    public removeNthFromEnd19(int val, ListNode next) {
        super(val, next);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 19.
        ListNode sentinel = new ListNode(-1, head);
        endIndex(sentinel, n);
        return sentinel.next;
    }

    private static int endIndex(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int nextBackIndex = endIndex(head.next, n);
        if (nextBackIndex == n) {
            head.next = head.next.next;
        }
        return nextBackIndex + 1;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 19.
        ListNode sentinel = new ListNode(-1, head);
        // p1,p2距離為刪除了倒序n , p2指向null時，讓p1指向刪除目標的前一個
        ListNode p1 = sentinel;// p1         p2
        ListNode p2 = sentinel;//    deleted null
        for (int i = 1; i <= n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 2, 3, 4, 5));

        assertEqual(removeNthFromEnd(getNodes(1, 2, 3, 4, 5), 5), "[2, 3, 4, 5]");
        assertEqual(removeNthFromEnd(getNodes(1, 2, 3, 4, 5), 1), "[1, 2, 3, 4]");
        assertEqual(removeNthFromEnd2(getNodes(1, 2, 3, 4, 5), 5), "[2, 3, 4, 5]");
        assertEqual(removeNthFromEnd2(getNodes(1, 2, 3, 4, 5), 1), "[1, 2, 3, 4]");
    }
}
