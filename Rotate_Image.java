public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        for(int r = 0; r < n / 2; r++)
            for(int c = r; c < n - 1 - r; c++){
                int tmp = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1- r];
                matrix[c][n - 1 - r] = matrix[r][c];
                matrix[r][c] = tmp;
            }
    }
}
