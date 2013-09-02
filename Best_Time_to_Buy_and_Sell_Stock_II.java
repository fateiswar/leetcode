public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null) return 9;
        int sum = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                sum += prices[i] - prices[i - 1];
        return sum;
    }
}
