package ian.linkedList;

import ian.ListNode;

public class MergeTwoLists21 extends ListNode {
    public MergeTwoLists21(int val, ListNode next) {
        super(val, next);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 21.
        if (list2 == null)
            return recursionSorted(list1);
        if (list1 == null)
            return recursionSorted(list2);

        ListNode head = list1;
        list1 = findTail(list1);
        list1.next = list2;
        return recursionSorted(head);
    }



    private static ListNode recursionSorted(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode sortedHead = recursionSorted(node.next);
        if (node.val > sortedHead.val) {
            ListNode next = sortedHead;
            while (next != null && next.next != null && node.val > next.next.val) {
                next = next.next;
            }
            node.next = next.next;
            next.next = node;
            return sortedHead;
        } else {
            node.next = sortedHead;
            return node;
        }
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode sentinel = new ListNode(-1, null);
        ListNode s = sentinel;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                s.next = p2;
                break;
            } else if (p2 == null) {
                s.next = p1;
                break;
            } else if (p1.val <= p2.val) {
                s.next = p1;
                s = p1;
                p1 = p1.next;
            } else {
                s.next = p2;
                s = p2;
                p2 = p2.next;
            }
        }
        return sentinel.next;
    }

    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        System.out.println(getNodes(1, 2, 4) + " ," + getNodes(1, 3, 4));
        expected = "[1, 1, 2, 3, 4, 4]";
        assertEqual(mergeTwoLists(getNodes(1, 2, 4), getNodes(1, 3, 4)));
        assertEqual(mergeTwoLists2(getNodes(1, 2, 4), getNodes(1, 3, 4)));
        assertEqual(mergeTwoLists3(getNodes(1, 2, 4), getNodes(1, 3, 4)));
    }
}
