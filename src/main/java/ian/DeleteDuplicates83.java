package ian;

public class DeleteDuplicates83 extends ListNode{
    public DeleteDuplicates83(int val, ListNode next) {
        super(val, next);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
                p1.next = p2;
            } else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = deleteDuplicates2(head.next);
        if (next.val == head.val) {
            head.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 1, 2, 3, 4, 5, 5));
        expected = "[1, 2, 3, 4, 5]";
        assertEqual(deleteDuplicates(getNodes(1, 1, 2, 3, 4, 5, 5)));
        assertEqual(deleteDuplicates2(getNodes(1, 1, 2, 3, 4, 5, 5)));
    }
}
