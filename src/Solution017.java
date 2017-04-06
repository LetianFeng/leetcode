import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution017 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || digits.contains("1") || digits.contains("0"))
            return new LinkedList<String>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<String>();

        for (char digit : digits.toCharArray()) {
            String letters = map.get(digit);

            if (res.size() == 0)
                for (char letter : letters.toCharArray())
                    res.add("" + letter);
            else {
                List<String> newRes = new LinkedList<>();
                for (String str : res) {
                    for (char letter : letters.toCharArray()) {
                        newRes.add(str + letter);
                    }
                }
                res = newRes;
            }
        }

        return res;
    }
}