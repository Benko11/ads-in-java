package Stack;

import static org.junit.Assert.*;

import Array.ArrayOutOfRange;
import org.junit.Test;

public class TestImplement {
    @Test
    public void object_equalities() throws StackFullException, StackEmptyException {
        var stack = new Stack<>(10);
        stack.push(3);
        stack.push(7);
        stack.push("a");

        var stack2 = new Stack<>(10);
        stack2.push(3);
        stack2.push(7);
        stack2.push("a");

        assertEquals(stack, stack2);
        stack.pop();
        assertNotEquals(stack, stack2);

        var stack3 = new Stack<>(9);
        stack3.push(3);
        stack3.push(7);
        stack3.push("a");
        assertNotEquals(stack, stack3);
    }

    @Test
    public void pop() throws StackFullException, StackEmptyException {
        var stack = new Stack<>(10);
        stack.push(12);
        assertEquals(12, stack.pop());
    }

    @Test
    public void parse() throws Exception {
        var toParse = "[[(({}{})())]]";
        var stack = new Stack<>(10);

        for (int i = 0; i < toParse.length(); i++) {
            var item = toParse.charAt(i);
            if (item == '[' || item == '(' || item == '{') {
                stack.push(item);
                continue;
            }

            if (item == ']') {
                if (!stack.pop().equals('[')) throw new Exception();
            }

            if (item == '}') {
                if (!stack.pop().equals('{')) throw new Exception();
            }

            if (item == ')') {
                if (!stack.pop().equals('(')) throw new Exception();
            }
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    public void palindrome() throws Exception {
        var string = "draw, o coward";
        var stack = new Stack<>(15);

        for (var c: string.toCharArray()) {
            if ('a' <= c && c <= 'z')
                stack.push(c);
        }

        for (var c: string.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                if (!stack.pop().equals(c)) {
                    throw new Exception();
                }
            }
        }

        assertTrue(true);
    }

    @Test
    public void infixPostfix() throws ArrayOutOfRange {
        var x = new InfixToPostfix("3*(4+5)-6/(1+2)");
        var output = x.translate();
        System.out.println(output);
    }
}
