public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int low = 0, high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target) return true;
            if(matrix[x][y] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
