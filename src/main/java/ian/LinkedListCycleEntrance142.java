package ian;


public class LinkedListCycleEntrance142 extends ListNode {
    public LinkedListCycleEntrance142(int val, ListNode next) {
        super(val, next);
    }


    public static ListNode findCircleEntrance(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("This is not a circular link.");
        }
        ListNode head = node;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != null && p2.next != null) {
            if (p1 == p2) {
                p1 = head;
                while (true) {
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2) {
                        return p1;
                    }
                }
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        throw new IllegalArgumentException("This is not a circular link.");
    }

    public static boolean isCircular(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode head = node;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
//        ListNode n1 = getNodes(1, 2, 3);
//        System.out.println(n1);
//        Assertions.assertFalse(isCircular(n1));
//
//        ListNode n2 = getNodes(1, 2, 3);
//        findTail(n2).next = n2;
//        Assertions.assertTrue(isCircular(n2));

        ListNode n3 = getNodes(1, 2, 3, 4, 5);
        ListNode tail = findTail(n3);
        tail.next = n3.next.next;
        System.out.println(findCircleEntrance(n3));
    }
}
