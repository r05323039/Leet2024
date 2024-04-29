package ian.linkedList;

import ian.ListNode;
import org.junit.jupiter.api.Assertions;

public class IsPalindrome234 extends ListNode {
    public IsPalindrome234(int val, ListNode next) {
        super(val, next);
    }

    public static boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        int i = 0, j = sb.length() - 1;
        while (i <= j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode n1 = getNodes(1, 2, 2, 1);
        System.out.println(n1);
        Assertions.assertTrue(isPalindrome(n1));

        ListNode n2 = getNodes(1, 2, 3, 2, 1);
        System.out.println(n2);
        Assertions.assertTrue(isPalindrome(n2));

        ListNode n3 = getNodes(1, 2, 3, 1);
        System.out.println(n3);
        Assertions.assertFalse(isPalindrome(n3));
    }
}
