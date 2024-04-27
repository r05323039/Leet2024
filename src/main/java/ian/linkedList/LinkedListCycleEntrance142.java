package ian.linkedList;


public class LinkedListCycleEntrance142 extends ListNode {
    public LinkedListCycleEntrance142(int val, ListNode next) {
        super(val, next);
    }


    public static ListNode findCircleEntrance(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }
        ListNode head = node;

        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                p1 = head;
                while (true) {
                    if (p1 == p2) {
                        return p1;
                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode node = getNodes(1, 2, 3, 4, 5);
        ListNode tail = findTail(node);
        tail.next = node.next.next;
        System.out.println(findCircleEntrance(node).val);

        ListNode node2 = getNodes(1, 2);
        node2.next.next = node2;
        System.out.println(findCircleEntrance(node2).val);
    }
}
