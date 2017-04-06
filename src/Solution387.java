public class Solution387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int[] record = new int[26];
        int first = 0;
        for (int current = 0; current < s.length(); current++) {
            record[s.charAt(current) - 'a']++;

            while (record[s.charAt(first) - 'a'] > 1 && first < current)
                first++;
        }

        return record[s.charAt(first) - 'a'] > 1 ? -1 : first;
    }
}