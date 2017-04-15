public class Solution414 {
    public int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        int count = 0;
        boolean containsMIN = false;

        for (int num : nums) {
            if (num == Integer.MIN_VALUE)
                containsMIN = true;
            if (num == first || num == second || num == third)
                continue;

            count++;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third){
                third = num;
            }
        }

        if (containsMIN)
            count++;

        if (count > 2)
            return third;

        return first;
    }
}