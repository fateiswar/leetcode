public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        char[] c = s.toCharArray();
        int[] dp = new int[c.length + 1];
        dp[0] = 1;
        for(int i = 0; i < c.length; i++){
            if(c[i] >= '1' && c[i] <= '9'){
                dp[i + 1] += dp[i];
            }
            if(i > 0 && c[i - 1] != '0' && ((c[i - 1] - '0') * 10 + c[i] - '0' >= 1 && (c[i - 1] - '0') * 10 + c[i] - '0' <= 26))
                dp[i + 1] += dp[i - 1];
        }
        return dp[c.length];
    }
}
