package ian.linkedList;

import ian.linkedList.ListNode;

public class RemoveElements203 extends ListNode {
    public RemoveElements203(int val, ListNode next) {
        super(val, next);
    }
    public static ListNode removeElements(ListNode node, int val) {
        // 203.
        ListNode sentinel = new ListNode(0, null);
        ListNode p = sentinel;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;//斷開舊的聯繫，單獨排查
            if (node.val != val) {
                p.next = node;
                p = node;
            }
            node = next;
        }
        return sentinel.next;
    }

    public static ListNode removeElements2(ListNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return removeElements2(node.next, val);
        } else {
            node.next = removeElements2(node.next, val);
            return node;
        }
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 2, 3, 4, 5));
        expected = "[1, 2, 4, 5]".toString();
        assertEqual(removeElements(getNodes(1, 2, 3, 4, 5), 3));
        assertEqual(removeElements2(getNodes(1, 2, 3, 4, 5), 3));
    }
}
