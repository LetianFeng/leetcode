public class Solution081 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[low] > nums[mid]) {
                if (nums[mid] <= target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else if (nums[mid] != nums[high]){
                low = mid + 1;
            } else {
                for (int i = low; i <= high; i++) {
                    if (nums[i] == target)
                        return true;
                }
                return false;
            }
        }

        return nums[low] == target;
    }

    public static void main(String[] args) {
        Solution081 sol =new Solution081();
        int[] nums = {1,3};
        int target = 2;
        System.out.println(sol.search(nums, target));
    }
}