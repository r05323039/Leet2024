package ian.stack;

import ian.TestModel;
import org.junit.jupiter.api.Assertions;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParentheses20 extends TestModel {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            }

            if ((symbol == ')' || symbol == ']' || symbol == '}') && stack.empty()) {
                return false;
            }
            if (symbol == ')' && stack.pop() != '(') {
                return false;
            }
            if (symbol == ']' && stack.pop() != '[') {
                return false;
            }
            if (symbol == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("("));
        assertFalse(isValid(")"));
    }
}
