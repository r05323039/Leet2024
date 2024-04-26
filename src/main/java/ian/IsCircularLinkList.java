package ian;


import org.junit.jupiter.api.Assertions;

public class IsCircularLinkList extends ListNode {
    public IsCircularLinkList(int val, ListNode next) {
        super(val, next);
    }

    public static boolean isCircular(ListNode node) {
        ListNode hea


        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = getNodes(1, 2, 3);
        System.out.println(n1);
        Assertions.assertTrue(isCircular(n1));

        ListNode n2 = getNodes(1, 2, 3);
        findTail(n2).next = n2;
        Assertions.assertTrue(isCircular(n2));
    }
}
