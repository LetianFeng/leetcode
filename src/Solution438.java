import java.util.LinkedList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();

        if (s == null || s.length() < p.length())
            return result;

        int[] map = new int[256];
        for (char c : p.toCharArray())
            map[c]++;

        int start = 0;
        int end = 0;
        int count = p.length();
        int sum = count;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0)
                count--;

            if (count == 0)
                result.add(start);


            if (end - start == p.length() && map[s.charAt(start++)]++ >= 0)
                count++;
        }

        return result;
    }
}