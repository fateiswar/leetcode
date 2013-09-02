public class Solution {
    public int numDistinct(String SS, String TT) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(SS == null || TT == null) return 0;
        char[] S = SS.toCharArray(), T = TT.toCharArray();
        if(S.length == 0) return T.length == 0 ? 1 : 0;
        if(T.length == 0) return 1;
        int[][] dp = new int[S.length + 1][T.length + 1];
        for(int i = 0; i <= S.length; i++)
            dp[i][0] = 1;
        for(int i = 1; i <= S.length; i++)
            for(int j = 1; j <= T.length; j++)
            {
                if(S[i - 1] == T[j - 1])
                    dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] += dp[i - 1][j];
            }
        return dp[S.length][T.length];
    }
}
