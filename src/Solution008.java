public class Solution008 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        boolean found = false;
        int plus = 1;
        long num = 0;
        for (char c : str.toCharArray()) {

            if (!found) {
                if (c == ' ')
                    continue;
                found = true;
                if (c == '-' || c == '+') {
                    plus = c == '+'? 1 : -1;
                    continue;
                }
            }

            int temp = charToInt(c);
            if (temp < 0)
                break;
            num = num * 10 + temp;
            if (num > Integer.MAX_VALUE)
                if (plus == 1)
                    return Integer.MAX_VALUE;
                else if (num - 1 > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;

        }

        return (int) num * plus;
    }

    public int charToInt(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return -1;
        }
    }
}