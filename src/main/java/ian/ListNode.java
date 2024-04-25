package ian;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class ListNode extends TestModel {
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

}