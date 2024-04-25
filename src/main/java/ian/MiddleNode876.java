package ian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleNode876 extends ListNode {
    public MiddleNode876(int val, ListNode next) {
        super(val, next);
    }

    public static ListNode middleNode(ListNode head) {
        int sum = count(head);
        for (int i = 0; i < sum / 2; i++) {
            head = head.next;
        }
        return head;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n = getNodes(1, 2, 3, 4, 5);
        System.out.println(n);
        Assertions.assertEquals(3, middleNode(n).val);
        Assertions.assertEquals(3, middleNode2(n).val);

        ListNode n2 = getNodes(1, 2, 3, 4, 5, 6);
        System.out.println(n2);
        Assertions.assertEquals(4, middleNode(n2).val);
        Assertions.assertEquals(4, middleNode2(n2).val);
    }
}
