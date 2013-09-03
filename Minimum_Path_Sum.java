//uncommitted
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 1; i >= 0 ; i--)
            for(int j = n - 1; j >= 0; j--)
            {
                if(i == m - 1) dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if(j == n - 1) dp[i][j] = grid[i][j] + dp[i + 1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        return dp[m - 1][n - 1];
    }
}
