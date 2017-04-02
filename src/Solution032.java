import java.util.Stack;

public class Solution032 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int max = 0;
        int start = -1;
        int size = s.length();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                start = i;
            } else {
                stack.pop();
                if (stack.isEmpty())
                    max = Math.max(i - start, max);
                else
                    max = Math.max(i - stack.peek(), max);
            }


        }

        return max;
    }

    public static void main(String[] args) {
        Solution032 sol = new Solution032();
        String test = "())()())))))))))(((()(()";
        System.out.println(sol.longestValidParentheses(test));
    }
}