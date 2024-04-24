package ian;

import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    void reverseList() {
        System.out.println(ListNode.reverseList(getSortedNodes(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList2(getSortedNodes(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList3(getSortedNodes(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList4(getSortedNodes(5)));
        System.out.println("----");
    }

    @Test
    void removeElements() {
        System.out.println(ListNode.removeElements(getSortedNodes(5), 3));
        System.out.println("----");
        System.out.println(ListNode.removeElements2(getSortedNodes(5), 3));
        System.out.println("----");
    }

    @Test
    void removeNthFromEnd() {
        System.out.println(ListNode.removeNthFromEnd(getSortedNodes(5), 5));
        System.out.println("----");
        System.out.println(ListNode.removeNthFromEnd(getSortedNodes(5), 1));
        System.out.println("----");
        System.out.println(ListNode.removeNthFromEnd2(getSortedNodes(5), 5));
        System.out.println("----");
        System.out.println(ListNode.removeNthFromEnd2(getSortedNodes(5), 1));
        System.out.println("----");
    }

    private ListNode getSortedNodes(int n) {
        ListNode sortedNodes = ListNode.init(n);
        System.out.println(sortedNodes);
        return sortedNodes;
    }

    @Test
    void deleteDuplicates() {
        System.out.println(ListNode.deleteDuplicates(getDuplicateNodes()));
        System.out.println("----");
        System.out.println(ListNode.deleteDuplicates2(getDuplicateNodes()));
        System.out.println("----");
    }

    private ListNode getDuplicateNodes() {
        ListNode list = getSortedNodes(5);
        ListNode head = new ListNode(1, list);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(5, null);
        System.out.println(head);
        return head;
    }
}