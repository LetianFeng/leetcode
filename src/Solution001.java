import java.util.HashMap;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[] {0,0};

        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.keySet().contains(num))
                return new int[] {map.get(num), i};
            else
                map.put(target - num, i++);
        }
        return new int[] {0,0};
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