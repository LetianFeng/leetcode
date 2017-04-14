public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            throw new IllegalArgumentException("No two sum solution");
        int i1 = 0, i2 = numbers.length - 1;
        while (i1 < i2) {
            int sum = numbers[i1] + numbers[i2];
            if (sum == target)
                return new int[]{i1 + 1, i2 + 1};
            else if (sum < target)
                i1++;
            else
                i2--;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}