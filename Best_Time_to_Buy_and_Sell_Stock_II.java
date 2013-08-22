public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int answer = 0;
        if(prices == null || prices.length <= 1) return 0;
        int low = -1, high = -1;
        for(int i = 1; i < prices.length; i++){
            if(low == -1){
                if(prices[i] > prices[i - 1])
                {
                    low = i - 1;
                }
            }else{
                if(prices[i] < prices[i - 1]){
                    answer += prices[i - 1] - prices[low];
                    low = -1;
                }
            }
        }
        if (low != -1)
            answer += prices[prices.length - 1] - prices[low];
        return answer;
    }
}
