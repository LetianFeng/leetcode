public class Solution007 {
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (res > max || res < min)
                return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}