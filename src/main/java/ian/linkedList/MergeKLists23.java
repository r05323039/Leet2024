package ian.linkedList;

import java.util.Arrays;

public class MergeKLists23 extends ListNode {
    public MergeKLists23(int val, ListNode next) {
        super(val, next);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return spilt(lists);
    }

    private static ListNode spilt(ListNode[] nodes) {
        if (nodes == null || nodes.length < 1) {
            return null;
        }
        if (nodes.length == 1) {
            return nodes[0];
        }
        ListNode[] left = Arrays.copyOfRange(nodes, 0, 1);
        ListNode[] right = Arrays.copyOfRange(nodes, 1, nodes.length);
        ListNode n1 = spilt(left);
        ListNode n2 = spilt(right);
        return MergeTwoLists21.mergeTwoLists3(n1, n2);
    }


    public static void main(String[] args) {
        ListNode n1 = getNodes(1, 4, 5);
        ListNode n2 = getNodes(1, 3, 4);
        ListNode n3 = getNodes(2, 6);
        System.out.println(n1 + "," + n2 + "," + n3);
        expected = "[1, 1, 2, 3, 4, 4, 5, 6]";
        assertEqual(mergeKLists(new ListNode[]{n1, n2, n3}));
    }
}
