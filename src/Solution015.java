import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new LinkedList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int twoSum = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == twoSum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    right--;
                } else if (sum < twoSum) {
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    right--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }

        return result;

    }
}