package ian;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListCycle141 extends ListNode {
    public LinkedListCycle141(int val, ListNode next) {
        super(val, next);
    }

    public static boolean isCircular(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode head = node;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = getNodes(1, 2, 3);
        System.out.println(n1);
        assertFalse(isCircular(n1));

        findTail(n1).next = n1;
        assertTrue(isCircular(n1));
    }
}
