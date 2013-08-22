public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length == 0) return 0;
        int answer = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            answer = Math.max(answer, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return answer;
    }
}
