package ian;

import ian.linkedList.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModel {

    protected static String expected;

    protected static void assertEqual(ListNode actual) {
        System.out.println(actual);
        assertEquals(expected, actual.toString());
    }

    protected static void assertEqual(ListNode actual, String expected) {
        System.out.println(actual);
        assertEquals(expected, actual.toString());
    }
}
