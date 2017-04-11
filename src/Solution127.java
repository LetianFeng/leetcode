import java.util.HashSet;
import java.util.List;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;

        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            // a new set for saving unvisited words in next level, which have only 1 different letter from words in beginSet
            HashSet<String> tmp = new HashSet<>();

            for (String str : beginSet) {
                char[] chars = str.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];

                    for (char c = 'a'; c < 'z'; c++) {
                        chars[i] = c;

                        String newStr = String.valueOf(chars);
                        if (endSet.contains(newStr))
                            return len + 1;

                        if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                            tmp.add(newStr);
                            visited.add(newStr);
                        }
                    }

                    chars[i] = origin;
                }
            }

            beginSet = tmp;
            len++;
        }

        return 0;
    }
}