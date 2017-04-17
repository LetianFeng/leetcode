public class Solution186 {
    public void reverseWords(char[] s) {
        if (s == null || s.length < 3)
            return;

        // reverse whole sentence
        int left = 0, right = s.length - 1;
        reverse(s, left, right);

        // reverse every word
        left = 0;
        right = 0;
        while (right < s.length) {
            if (s[right] == ' ') {
                reverse(s, left, right - 1);
                left = right + 1;
            }
            right++;
        }

        //reverse the last word
        reverse(s, left, right - 1);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}