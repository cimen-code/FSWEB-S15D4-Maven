package org.example;

import java.util.Locale;
import java.util.Stack;

public class Main {

    public static boolean checkForPalindrome(String input) {

        if (input == null) {
            return false;
        }

        String cleaned = input
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase(Locale.ROOT);

        Stack<Character> stack = new Stack<>();

        for (char character : cleaned.toCharArray()) {
            stack.push(character);
        }

        for (char character : cleaned.toCharArray()) {
            if (character != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static String convertDecimalToBinary(int number) {

        if (number == 0) {
            return "0";
        }

        boolean negative = number < 0;
        long value = Math.abs((long) number);

        Stack<Integer> stack = new Stack<>();

        while (value > 0) {
            stack.push((int) (value % 2));
            value /= 2;
        }

        StringBuilder result = new StringBuilder();

        if (negative) {
            result.append("-");
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
    }
}
