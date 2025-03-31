package org.hm.datastructures;

import java.util.Map;
import java.util.Stack;

public class StackBalancedParentheses {
    private static final Map<Character, Character> parehnthesesMap =
            Map.of(')', '(', '}', '{', ']', '[');

    private static boolean balancedParentheses(String exp) {
        Stack<Character> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (parehnthesesMap.containsValue(c)) {
                stack.push(c);
            } else if (parehnthesesMap.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != parehnthesesMap.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedParentheses("{()[]}"));
        System.out.println(balancedParentheses("{()[]}}"));
        System.out.println(balancedParentheses("{([)]}"));
    }
}
