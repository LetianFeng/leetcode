public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] letters = new int[256];
        int max = 0;
        int count = 0;

        int left = 0, right = 0;
        int len = s.length();
        while (right < len) {
            if (letters[s.charAt(right)]++ == 0) {
                count++;
                max = Math.max(count, max);
            } else {
                char rightChar = s.charAt(right);
                while (s.charAt(left) != rightChar) {
                    letters[s.charAt(left)]--;
                    left++;
                }
                letters[s.charAt(left)]--;
                left++;

                count = right - left + 1;
            }

            right++;
        }

        return max;
    }
}