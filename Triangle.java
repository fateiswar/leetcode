public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size() == 0) return 0;
        int[][] dp = new int[2][triangle.size()];
        int sz = triangle.size();
        for(int i = 0; i < sz; i++) dp[0][i] = triangle.get(sz - 1).get(i);
        int curr = 0;
        for(int i = sz - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++)
            {
                dp[curr^1][j] = Math.min(dp[curr][j] + triangle.get(i).get(j),
                                        dp[curr][j + 1] + triangle.get(i).get(j));
            }
            curr = curr^1;
        }
        return dp[curr][0];
    }
}
