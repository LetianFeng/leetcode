import java.util.Stack;

public class Solution020 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution020 sol = new Solution020();
        String test = "()[]{}";

        System.out.println(sol.isValid(test));
    }
}