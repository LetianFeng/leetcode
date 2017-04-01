public class Solution005 {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;

        if (s.length() == 0)
            return s;

        int size = s.length();

        for (int start = 0, end = size, subsize = size; subsize > 0; subsize--) {

            while (end <= size) {

                if (isPalindromic(s, start, end) && end - start > 0)
                    return s.substring(start, end);

                start++;
                end++;
            }

            start = 0;
            end = subsize - 1;
        }

        return "";
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (end - start > 1) {
            if (s.charAt(start) != s.charAt(end - 1))
                return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution005 sol = new Solution005();

        System.out.println(sol.longestPalindrome(input));
    }
}