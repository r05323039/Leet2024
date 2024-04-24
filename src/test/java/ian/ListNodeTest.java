package ian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void reverseList() {
        System.out.println(ListNode.reverseList(ListNode.init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList2(ListNode.init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList3(ListNode.init()));
        System.out.println("----");
        System.out.println(ListNode.reverseList4(ListNode.init()));
        System.out.println("----");
    }

    @Test
    void removeElements() {
        System.out.println(ListNode.removeElements(ListNode.init(),3));
    }
}