package ian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListNodeTest {

    private String expected;

    private void assertEqual(ListNode actual) {
        System.out.println(actual);
        assertEquals(expected, actual.toString());
    }

    private void assertEqual(ListNode actual, String expected) {
        System.out.println(actual);
        assertEquals(expected, actual.toString());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("Running test: " + testInfo.getDisplayName());

    }

    @Test
    void reverseList() {
        System.out.println(getNodes(1, 2, 3, 4, 5));
        expected = "[5, 4, 3, 2, 1]".toString();

        assertEqual(ListNode.reverseList(getNodes(1, 2, 3, 4, 5)));

        assertEqual(ListNode.reverseList2(getNodes(1, 2, 3, 4, 5)));

        assertEqual(ListNode.reverseList3(getNodes(1, 2, 3, 4, 5)));

        assertEqual(ListNode.reverseList4(getNodes(1, 2, 3, 4, 5)));
    }

    @Test
    void removeElements() {
        System.out.println(getNodes(1, 2, 3, 4, 5));
        expected = "[1, 2, 4, 5]".toString();
        assertEqual(ListNode.removeElements(getNodes(1, 2, 3, 4, 5), 3));
        assertEqual(ListNode.removeElements2(getNodes(1, 2, 3, 4, 5), 3));
    }

    @Test
    void removeNthFromEnd() {
        System.out.println(getNodes(1, 2, 3, 4, 5));

        assertEqual(ListNode.removeNthFromEnd(getNodes(1, 2, 3, 4, 5), 5), "[2, 3, 4, 5]");
        assertEqual(ListNode.removeNthFromEnd(getNodes(1, 2, 3, 4, 5), 1), "[1, 2, 3, 4]");
        assertEqual(ListNode.removeNthFromEnd2(getNodes(1, 2, 3, 4, 5), 5), "[2, 3, 4, 5]");
        assertEqual(ListNode.removeNthFromEnd2(getNodes(1, 2, 3, 4, 5), 1), "[1, 2, 3, 4]");
    }

    @Test
    void deleteDuplicates() {
        System.out.println(getNodes(1, 1, 2, 3, 4, 5, 5));
        expected = "[1, 2, 3, 4, 5]";
        assertEqual(ListNode.deleteDuplicates(getNodes(1, 1, 2, 3, 4, 5, 5)));
        assertEqual(ListNode.deleteDuplicates2(getNodes(1, 1, 2, 3, 4, 5, 5)));
    }

    @Test
    void deleteAllDuplicates() {
        System.out.println(getNodes(3, 4, 6, 2));
    }

    private ListNode getDuplicateNodes() {
        ListNode list = getNodes(1, 2, 3, 4, 5);
        ListNode head = new ListNode(1, list);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(5, null);
        return head;
    }

    private ListNode getNodes(int... val) {
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