public class Solution048 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        if (size == 1)
            return;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int leftUp = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
                matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                matrix[j][size - i - 1] = leftUp;
            }
        }

        for (int[] col : matrix) {
            for (int num : col)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution048 sol = new Solution048();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(matrix);
    }
}