package ian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void reverseList() {
        System.out.println(ListNode.reverseList(ListNode.init(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList2(ListNode.init(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList3(ListNode.init(5)));
        System.out.println("----");
        System.out.println(ListNode.reverseList4(ListNode.init(5)));
        System.out.println("----");
    }

    @Test
    void removeElements() {
        System.out.println(ListNode.removeElements(ListNode.init(5), 3));

        System.out.println(ListNode.removeElements2(ListNode.init(5), 3));
    }

    @Test
    void removeNthFromEnd() {
        System.out.println(ListNode.removeElements(ListNode.init(5), 5));
        System.out.println(ListNode.removeElements(ListNode.init(5), 1));
        System.out.println(ListNode.removeElements2(ListNode.init(5), 5));
        System.out.println(ListNode.removeElements2(ListNode.init(5), 1));
    }
}