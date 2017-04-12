public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;

        for (int[] vector : matrix) {
            if (target >= vector[0] && target <= vector[n - 1]) {
                for (int element : vector) {
                    if (target == element)
                        return true;
                    if (target < element)
                        break;
                }
            }
        }

        return false;
    }
}