package ian.linkedList;

import ian.ListNode;
import ian.minHeap.MinHeap;
import ian.priorityQueue.PriorityQueue1;

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
            return nodes[0];//[{1,2,3}] -> {1,2,3}
        }
        ListNode[] left = Arrays.copyOfRange(nodes, 0, 1);//[{1,2,3},{4,5},{6}] ->[{1,2,3}] + [{4,5},{6}]
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

        assertEqual(mergeKListsByMinHeap(new ListNode[]{n1, n2, n3}));
    }

    public static ListNode mergeKListsByMinHeap(ListNode[] nodes) {
        MinHeap queue = new MinHeap(nodes.length);
        for (ListNode head : nodes) {//將鏈表的頭節點加入小頂堆
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            if (min.next != null) {
                queue.offer(min.next);//鏈表的下一個節點加入小頂堆
            }
            p.next = min;//移除的最小值，加入新的鏈表
            p = min;
        }
        return s.next;
    }
}
