package org.hm.datastructures;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class StackPrefixPostfixEval {
    private static final Map<Character, BiFunction<Integer, Integer, Integer>> operatorMap = Map.of(
            '+', (a, b) -> a + b,
            '-', (a, b) -> a - b,
            '*', (a, b) -> a * b,
            '/', (a, b) -> a / b);

    private static final Map<Character, Integer> operatorPrecedence = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2);

    private static final Map<Character, Character> parehnthesesMap =
            Map.of(')', '(', '}', '{', ']', '[');

    private static int postfixEval(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (!operatorMap.containsKey(c)) {
                stack.push(c - '0');
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(operatorMap.get(c).apply(num1, num2));
            }
        }
        return stack.pop();
    }

    private static int prefixEval(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (!operatorMap.containsKey(c)) {
                stack.push(c - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(operatorMap.get(c).apply(num1, num2));
            }
        }
        return stack.pop();
    }

    private static String convertInfixToPostfix(String exp) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (isOperand(c) ) {
                res.append(c);
            } else if (operatorMap.containsKey(c)) {
                while (!stack.isEmpty() && !parehnthesesMap.containsValue(c)
                        && hasHigherPrecedence(stack.peek(), c)) {
                    res.append(stack.pop());
                }
                stack.push(c);
            } else if (parehnthesesMap.containsValue(c)) {
                stack.push(c);
            } else if (parehnthesesMap.containsKey(c)) {
                while (!stack.isEmpty() && !parehnthesesMap.containsValue(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) res.append(stack.pop());
        return res.toString();
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        if (!operatorPrecedence.containsKey(op1) || !operatorPrecedence.containsKey(op2)) {
            return false;
        }
        return operatorPrecedence.get(op1) >= operatorPrecedence.get(op2);
    }

    private static boolean isOperand(char c) {
        return !operatorMap.containsKey(c) && !parehnthesesMap.containsKey(c) && !parehnthesesMap.containsValue(c);
    }

    public static void main(String[] args) {
        String postfixExp = "23*54*+9-";
        System.out.println("Postfix: " + postfixExp + " ==> " + postfixEval(postfixExp));

        String prefixExp = "-+*23*549";
        System.out.println("Prefix: " + prefixExp + " ==> " + prefixEval(prefixExp));

        String infixToPostfix1 = "A+B*C-D*E";
        System.out.println(infixToPostfix1 + " ==> " + convertInfixToPostfix(infixToPostfix1));

        String infixToPostfix2 = "((A+B)*C-D)*E";
        System.out.println(infixToPostfix2 + " ==> " + convertInfixToPostfix(infixToPostfix2));

        String infixToPostfix3 = "A*(B+C)";
        System.out.println(infixToPostfix3 + " ==> " + convertInfixToPostfix(infixToPostfix3));
    }
}
