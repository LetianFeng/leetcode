public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || t.length() != s.length())
            return false;

        int[] anagram = new int[26];
        for (char c : s.toCharArray()) {
            anagram[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (anagram[c - 'a']-- == 0)
                return false;
        }

        return true;
    }
}