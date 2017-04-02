import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneMoreParenthesis(result, "", 0, 0, n);
        return result;
    }

    private void generateOneMoreParenthesis(List<String> result, String s, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            generateOneMoreParenthesis(result, s + "(", left + 1, right, n);
        }
        if (right < left) {
            generateOneMoreParenthesis(result, s + ")", left, right + 1, n);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        Solution022 sol = new Solution022();

        System.out.println(sol.generateParenthesis(n).toString());
    }
}