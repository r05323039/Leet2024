package ian.linkedList;

import ian.ListNode;

public class ReverseList206 extends ListNode {
    public ReverseList206(int val, ListNode next) {
        super(val, next);
    }

    public static ListNode reverseList(ListNode head) {
        // 206.
        ListNode newNode = null;
        ListNode p = head;
        while (p != null) {
            newNode = new ListNode(p.val, newNode);
            p = p.next;
        }
        return newNode;
    }

    public static ListNode reverseList2(ListNode node) {
        if (node == null || node.next == null) {
            return node;// tail
        }

        ListNode last = reverseList2(node.next);
        node.next.next = node;
        node.next = null;//反轉後的尾巴要指向null 不然最後一組會變成互相指向，使用for就沒有終結條件了
        return last;//把原本的tail作為反轉後的head返回
    }

    public static ListNode reverseList3(ListNode node) {
        /**
         *  1 -> 2 -> 3 -> 4 -> null
         *  2 -> 1 -> 3 -> 4 -> null
         *  3 -> 2 -> 1 -> 4 -> null
         *  4 -> 3 -> 2 -> 1 -> null
         */
        if (node == null || node.next == null) {
            return node;
        }

        ListNode oldHead = node;
        ListNode newHead = node;
        while (oldHead.next != null) {
            ListNode oldNext = oldHead.next;//放到臨時變數，下一步要斷開
            oldHead.next = oldNext.next;
            oldNext.next = newHead;
            newHead = oldNext;
        }
        return newHead;
    }

    public static ListNode reverseList4(ListNode node) {
        /**
         * 1 -> 2 -> 3 -> null
         * null
         *
         * 2 -> 3
         * 1 -> null
         */
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head1 = node;
        ListNode head2 = null;
        while (head1 != null) {
            ListNode tempHead = head1.next;
            head1.next = head2;
            head2 = head1;
            head1 = tempHead;
        }
        return head2;
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 2, 3, 4, 5));
        expected = "[5, 4, 3, 2, 1]".toString();

        assertEqual(reverseList(getNodes(1, 2, 3, 4, 5)));

        assertEqual(reverseList2(getNodes(1, 2, 3, 4, 5)));

        assertEqual(reverseList3(getNodes(1, 2, 3, 4, 5)));

        assertEqual(reverseList4(getNodes(1, 2, 3, 4, 5)));
    }
}
