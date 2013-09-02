public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word1 == null && word2 == null) return 0;
        if(word1 == null) return word2.length();
        if(word2 == null) return word1.length();
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        for(int i = 1; i <= w1.length; i++)
            dp[i][0] = i;
        for(int i = 1; i <= w2.length; i++)
            dp[0][i] = i;
        for(int i = 1; i <= w1.length; i++)
            for(int j = 1; j <= w2.length; j++)
            {
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                if(w1[i - 1] == w2[j - 1])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                else
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        return dp[w1.length][w2.length];
    }
}
