package Stack;

import Array.ArrayOutOfRange;

public class InfixToPostfix {
    private final StackX stack;
    private final String input;
    private String output;

    public InfixToPostfix(String input) {
        this.input = input;
        stack = new StackX(this.input.length());
    }

    public String translate() throws ArrayOutOfRange {
        for (int i = 0; i < input.length(); i++) {
            var currentChar = input.charAt(i);
            switch (currentChar) {
                case '+', '-' -> parseOperation(currentChar, 1);
                case '*', '/' -> parseOperation(currentChar, 2);
                case '(' -> stack.push(currentChar);
                case ')' -> parseBracket(currentChar);
                default -> {
                    if (output == null) {
                        output = String.valueOf(currentChar);
                    } else {
                        var temp = new StringBuilder();
                        temp.append(output);
                        temp.append(currentChar);
                        output = temp.toString();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            var temp = new StringBuffer();
            temp.append(output);
            temp.append(stack.pop());
            output = temp.toString();
        }

        return output;
    }

    public void parseOperation(Character operation, int precedence1) throws ArrayOutOfRange {
        while (!stack.isEmpty()) {
            var topOperation = stack.pop();
            if (topOperation == '(') {
                stack.push(topOperation);
                break;
            }

            int precedence2;
            if (topOperation == '+' || topOperation == '-') {
                precedence2 = 1;
            } else {
                precedence2 = 2;
            }

            if (precedence2 < precedence1) {
                stack.push(topOperation);
                break;
            }

            var temp = new StringBuffer();
            temp.append(output);
            temp.append(topOperation);
            output = temp.toString();
        }

        stack.push(operation);
    }

    public void parseBracket(Character ch) throws ArrayOutOfRange {
        var temp = new StringBuilder();
        while (!stack.isEmpty()) {
            var popped = stack.pop();
            if (popped == '(') break;
            temp.append(output);
            temp.append(popped);
        }

        output = temp.toString();
    }
}
