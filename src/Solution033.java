public class Solution033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        Solution033 sol =new Solution033();
        int[] nums = {7,8,9,0,1,2,3};
        int target = 2;
        System.out.println(sol.search(nums, target));
    }
}