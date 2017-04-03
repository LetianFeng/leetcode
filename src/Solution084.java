public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int max = 0;
        int len = heights.length;

        for (int start = 0; start < len; start++) {
            int minHeight = Integer.MAX_VALUE;

            for (int end = start; end < len; end++) {
                if (heights[end] < minHeight)
                    minHeight = heights[end];
                int area = minHeight * (end - start + 1);
                if (area > max)
                    max = area;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        Solution084 sol = new Solution084();

        System.out.print(sol.largestRectangleArea(heights));
    }
}