import java.util.HashMap;

public class Solution076 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }

        int size = s.length();
        int left = 0;
        int minLeft = 0;
        int minLen = size + 1;
        int count = 0;
        int sum = t.length();

        for (int right = 0; right < size; right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    count++;
            }

            while (count == sum) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0)
                        count--;
                }
                left++;
            }
        }

        if (minLen > size)
            return "";

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        Solution076 sol = new Solution076();
        String s = "aadsbcdsaf;lksnsvxcidshogfi[pansdkjxczhfkjhklasdhfiuqrwtskjahz<jalkjdslkj";
        String t = "abcd";
        System.out.println(sol.minWindow(s, t));
    }
}