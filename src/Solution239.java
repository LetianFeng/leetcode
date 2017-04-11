public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1)
            return new int[0];

        int size = nums.length;
        int[] result = new int[size - k + 1];
        int left = 0, right = 0;

        int maxPos = 0;
        int ri = 0;
        result[0] = nums[0];

        while (right < size) {
            if (right - left >= k) {
                if (nums[right] > nums[maxPos]) {
                    maxPos = right;
                    left++;
                } else if (left++ == maxPos) {
                    maxPos = left;

                    for (int i = left + 1; i <= right; i++) {
                        if (nums[i] > nums[maxPos])
                            maxPos = i;
                    }
                }

                result[++ri] = nums[maxPos];
            } else {
                if (nums[right] > nums[maxPos]) {
                    maxPos = right;
                    result[0] = nums[right];
                }
            }

            right++;
        }

        return result;
    }
}