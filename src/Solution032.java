import java.util.Stack;

public class Solution032 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int left = 0;

            for (char c : s.substring(i).toCharArray()) {
                if (c == '(') {
                    left++;
                    count++;
                } else if (left != 0) {
                    left--;
                    count++;
                    if (left == 0 && count > max)
                        max = count;
                } else
                    break;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        Solution032 sol = new Solution032();
        String test = "()(()(())(";
        System.out.println(sol.longestValidParentheses(test));
    }
}