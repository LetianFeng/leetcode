import java.util.Stack;

public class Solution020 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (!stack.isEmpty() && validPair(stack.peek(), s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    private boolean validPair(char peek, char character) {
        if (peek == '(' && character == ')')
            return true;
        if (peek == '[' && character == ']')
            return true;
        if (peek == '{' && character == '}')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution020 sol = new Solution020();
        String test = "()[]{}";

        System.out.println(sol.isValid(test));
    }
}