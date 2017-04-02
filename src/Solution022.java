import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        return generateOneMoreParenthesis(result, n);
    }

    private List<String> generateOneMoreParenthesis(List<String> list, int n) {
        if (n == 0)
            return list;

        List<String> result = new ArrayList<>();
        for (String s : list) {
            String s1 = "(" + s + ")";
            String s2 = "(" + ")" + s;
            String s3 = s + "(" + ")";
            if (!result.contains(s1))
                result.add(s1);
            if (!result.contains(s2))
                result.add(s2);
            if (!result.contains(s3))
                result.add(s3);
        }
        return generateOneMoreParenthesis(result, n - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        Solution022 sol = new Solution022();

        System.out.println(sol.generateParenthesis(n).toString());
    }
}