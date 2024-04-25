package ian;

import org.junit.jupiter.api.Assertions;

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

    public static void main(String[] args) {
        ListNode n = getNodes(1, 2, 3, 4, 5);
        System.out.println(n);
        Assertions.assertEquals(3, middleNode(n).val);

        ListNode n2 = getNodes(1, 2, 3, 4, 5, 6);
        System.out.println(n2);
        Assertions.assertEquals(4, middleNode(n2).val);
    }
}
