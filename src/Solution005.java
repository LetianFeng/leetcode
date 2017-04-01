public class Solution005 {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;

        if (s.length() == 0)
            return s;

        int size = s.length();

        for (int start = 0, end = size, subsize = size; subsize > 0; subsize--) {

            while (end <= size) {
                String sub = s.substring(start, end);

                if (isPalindromic(sub) && sub.length() > 0)
                    return sub;

                start++;
                end++;
            }

            start = 0;
            end = subsize - 1;
        }

        return "";
    }

    private boolean isPalindromic(String s) {
        if (s == null || s.length() < 2)
            return true;


        int size = s.length();
        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution005 sol = new Solution005();

        System.out.println(sol.longestPalindrome(input));
    }
}