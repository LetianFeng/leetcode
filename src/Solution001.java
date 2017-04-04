import java.util.HashMap;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(num))
                return new int[]{map.get(num), i};
            else map.put(target - num, i);
            i++;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,5};
        int target = 9;

        Solution001 sol = new Solution001();
        int[] result = sol.twoSum(numbers, target);
        for (int num : result)
            System.out.print(num + " ");
    }
}