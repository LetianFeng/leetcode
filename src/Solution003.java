public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] letters = new int[256];
        int max = 0;
        int len = 1;

        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();

        while (right <s.length()) {
            if (letters[chars[right]]++ == 0) {
                if (right - left + 1 > len)
                    len = right - left + 1;
            }

            while (letters[chars[right]] > 1)
                letters[chars[left++]]--;

            right++;
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution003 sol = new Solution003();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}