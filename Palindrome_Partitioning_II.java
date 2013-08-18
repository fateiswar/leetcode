public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() <= 1) return 0;
        boolean[][] pal = new boolean[s.length()][s.length()];
        int len = s.length();
        for(int i = 0; i < len; i++) pal[i][i] = true;
        for(int i = 1; i < len; i++) pal[i][i - 1] = true;
        for(int l = 1; l <= len; l++)
            for(int i = 0; i + l < len; i++)
                if(s.charAt(i) == s.charAt(i + l) && pal[i + 1][i + l - 1])
                    pal[i][i + l] = true;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i < len; i++){
            if(pal[0][i]){
                dp[i] = 0;
                continue;
            }
            for(int j = i; j > 0; j--)
                if(pal[j][i]){
                    if(dp[i] == -1 || dp[i] > dp[j - 1] + 1)
                        dp[i] = dp[j - 1] + 1;
                }
        }
        return dp[len - 1];
    }
}
