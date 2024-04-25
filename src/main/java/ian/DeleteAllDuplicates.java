package ian;

public class DeleteAllDuplicates extends ListNode{
    public DeleteAllDuplicates(int val, ListNode next) {
        super(val, next);
    }
    public static ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1, head);
        ListNode checked = sentinel;
        ListNode p1, p2;

        while ((p1 = checked.next) != null && (p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                while ((p2 = p2.next) != null && p1.val == p2.val) {
                }
                checked.next = p2;
            } else {
                checked = p1;
            }
        }

        return sentinel.next;
    }

    public static ListNode deleteAllDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return deleteAllDuplicates2(next);
        }
        head.next = deleteAllDuplicates2(next);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 1, 2, 2, 4, 5, 6, 6));
        expected = "[4, 5]";
        assertEqual(deleteAllDuplicates(getNodes(1, 1, 2, 2, 4, 5, 6, 6)));
        assertEqual(deleteAllDuplicates2(getNodes(1, 1, 2, 2, 4, 5, 6, 6)));

        System.out.println(getNodes(1, 1, 2, 2, 4, 5, 6));
        expected = "[4, 5, 6]";
        assertEqual(deleteAllDuplicates(getNodes(1, 1, 2, 2, 4, 5, 6)));
        assertEqual(deleteAllDuplicates2(getNodes(1, 1, 2, 2, 4, 5, 6)));
    }
}
