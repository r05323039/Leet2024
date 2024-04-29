package ian.linkedList;

import ian.TestModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class ListNode extends TestModel {
    int val;
    ListNode next;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    protected static ListNode getNodes(int... val) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;
        for (int v : val) {
            ListNode newNode = new ListNode(v, null);
            p.next = newNode;
            p = newNode;
        }
        return sentinel.next;
    }

    protected static int count(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }

    protected static ListNode findTail(ListNode list) {
        while (list != null && list.next != null) {
            list = list.next;
        }
        return list;
    }
}