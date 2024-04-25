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
        System.out.println(getNodes(1, 1, 2, 2, 4, 5, 6, 6));
        expected = "[4, 5]";
        assertEqual(ListNode.deleteAllDuplicates(getNodes(1, 1, 2, 2, 4, 5, 6, 6)));
        assertEqual(ListNode.deleteAllDuplicates2(getNodes(1, 1, 2, 2, 4, 5, 6, 6)));


        System.out.println(getNodes(1, 1, 2, 2, 4, 5, 6));
        expected = "[4, 5, 6]";
        assertEqual(ListNode.deleteAllDuplicates(getNodes(1, 1, 2, 2, 4, 5, 6)));
        assertEqual(ListNode.deleteAllDuplicates2(getNodes(1, 1, 2, 2, 4, 5, 6)));

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

    @Test
    void mergeTwoLists() {
        System.out.println(getNodes(1, 2, 4) + " ," + getNodes(1, 3, 4));
        expected = "[1, 1, 2, 3, 4, 4]";
        assertEqual(ListNode.mergeTwoLists(getNodes(1, 2, 4), getNodes(1, 3, 4)));
        assertEqual(ListNode.mergeTwoLists2(getNodes(1, 2, 4), getNodes(1, 3, 4)));
        assertEqual(ListNode.mergeTwoLists3(getNodes(1, 2, 4), getNodes(1, 3, 4)));

    }
}