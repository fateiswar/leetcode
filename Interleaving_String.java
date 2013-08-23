public class Solution {
    public boolean isInterleave(String ss1, String ss2, String ss3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(ss3 == null) return (ss1 == null && ss2 == null);
        if(ss1 == null) return ss2.equals(ss3);
        if(ss2 == null) return ss1.equals(ss3);
        if(ss1.length() + ss2.length() != ss3.length()) return false;
        char[] s1 = ss1.toCharArray(), s2 = ss2.toCharArray(), s3 = ss3.toCharArray();
        boolean[][] dp = new boolean[s1.length + 1][s2.length + 1];
        dp[0][0] = true;
        for(int i = 0; i <= s1.length; i++)
            for(int j = 0; j <= s2.length; j++)
            {
                if(i > 0 && s1[i - 1] == s3[i + j - 1]) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if(j > 0 && s2[j - 1] == s3[i + j - 1]) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        return dp[s1.length][s2.length];
    }
}
