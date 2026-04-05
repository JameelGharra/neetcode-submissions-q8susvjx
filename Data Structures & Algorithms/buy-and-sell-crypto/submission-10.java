class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        
        int buyIndex = 0;
        int result = prices[1]-prices[0];
        int bestSell = prices[1];
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i]-prices[buyIndex] > result) {
                bestSell = prices[i];
                result = prices[i] - prices[buyIndex]; 
            }
            if(prices[buyIndex] > prices[i]) { 
                buyIndex = i;
            }
        }
        return Math.max(0, result);
    }
}
