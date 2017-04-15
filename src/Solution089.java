import java.util.*;

public class Solution089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++)
            result.add(i ^ (i >> 1));
        return result;
    }
}