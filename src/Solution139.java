import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty())
            return false;

        boolean[] breaker = new boolean[s.length() + 1];
        breaker[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!breaker[j] && breaker[i] && wordDict.contains(s.substring(i, j)))
                    breaker[j] = true;
            }
        }

        return breaker[s.length()];
    }
}