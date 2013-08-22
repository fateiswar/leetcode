public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[prices.length - 1];
        int answer = dp[prices.length - 1];
        for(int i = prices.length - 2; i > 0; i--){
            int sub = Math.max(0, max - prices[i]);
            answer = Math.max(answer, sub + dp[i - 1]);
            max = Math.max(max, prices[i]);
        }
        return answer;
    }
}
