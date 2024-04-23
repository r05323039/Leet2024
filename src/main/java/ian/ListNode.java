package ian;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListNode {
    int value;
    ListNode next;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode node = this;
        while (node != null) {
            sb.append(node.value);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode p = head;
        while (p != null) {
            newNode = new ListNode(p.value, newNode);
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

    private static ListNode reverseList4(ListNode node) {
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
        System.out.println(ListNode.reverseList(init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList2(init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList3(init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList4(init()));
        System.out.println("----");
    }

    private static ListNode init() {
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(n1);
        return n1;
    }
}
