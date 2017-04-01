public class Solution005 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return null;

        int size = s.length();

        String result = "";

        for (int start = 0, end = 0; start < size; end++) {
            String sub = s.substring(start, end);

            if(isPalindromic(sub) && sub.length() > result.length()) {
                result = sub;
            }
            if (end >= size) {
                start++;
                end = start;
            }
        }

        return result;
    }

    private boolean isPalindromic(String s) {
        if(s == null || s.length() < 2)
            return true;


        int size = s.length();
        for(int i = 0; i < size/2; i++) {
            if (s.charAt(i) != s.charAt(size  - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "babad";
        Solution005 sol = new Solution005();

        System.out.println(sol.longestPalindrome(input));
    }
}