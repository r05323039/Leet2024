package ian.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateReversePolishNotation150 {
    public static int evalRPN(String[] tokens) {
        List<String> operators = List.of("+", "-", "*", "/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int result = 0;
            String token = tokens[i];
            if (operators.contains(token)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] t1 = {"2", "1", "+", "3", "*"};
        assertEquals(9, evalRPN(t1));

        String[] t2 = {"4", "13", "5", "/", "+"};
        assertEquals(6, evalRPN(t2));

        String[] t3 = {"4"};
        assertEquals(4, evalRPN(t3));

        String[] t4 = {"4", "3", "-"};
        assertEquals(1, evalRPN(t4));

        String[] t5 = {"3", "11", "+", "5", "-"};
        assertEquals(9, evalRPN(t5));
    }
}
