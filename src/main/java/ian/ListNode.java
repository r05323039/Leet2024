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

    public static ListNode init(int n) {
        ListNode head = null;
        for (int i = n; i >= 1; i--) {
            head = new ListNode(i, head);
        }
        return head;
    }

    // 反轉鏈表
    public static ListNode reverseList(ListNode head) {
        // 206.
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

    // 指定值，移除鏈表
    public static ListNode removeElements(ListNode node, int val) {
        // 203.
        ListNode sentinel = new ListNode(0, null);
        ListNode p = sentinel;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;//斷開舊的聯繫，單獨排查
            if (node.value != val) {
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

        if (node.value == val) {
            return removeElements2(node.next, val);
        } else {
            node.next = removeElements2(node.next, val);
            return node;
        }
    }

    //移除倒數第n個鏈表
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 19.
        ListNode sentinel = new ListNode(-1, head);
        endIndex(sentinel, n);
        return sentinel.next;
    }

    private static int endIndex(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int nextBackIndex = endIndex(head.next, n);
        if (nextBackIndex == n) {
            head.next = head.next.next;
        }
        return nextBackIndex + 1;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 19.
        ListNode sentinel = new ListNode(-1, head);
        // p1,p2距離為刪除了倒序n , p2指向null時，讓p1指向刪除目標的前一個
        ListNode p1 = sentinel;// p1         p2
        ListNode p2 = sentinel;//    deleted null
        for (int i = 1; i <= n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return sentinel.next;
    }

    //移除重複值
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            if (p1.value == p2.value) {
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
        if (next.value == head.value) {
            head.next = next.next;
        }
        return head;
    }

    //重複值，全部移除
    public static ListNode deleteAllDuplicates(ListNode head) {
        return head;
    }
}
