class Solution {
    // O(n^2) - O(1)
    // public int maxProfit(int[] prices) {
    //     int result = 0;
    //     for(int i = 0; i < prices.length-1; ++i) {
    //         for(int j = i+1; j < prices.length; ++j) {
    //             result = Math.max(result, prices[j]-prices[i]);
    //         }
    //     }
    //     return result;
    // }

    // Two pointers: O(n) - O(1)
    // public int maxProfit(int[] prices) {
    //     if(prices.length <= 1)
    //         return 0;
    //     int left = 0, right = 1, result = 0;
    //     while(right < prices.length) {
    //         int profit = prices[right]-prices[left];
    //         result = Math.max(result, profit);
    //         if(prices[right] < prices[left])
    //             left = right;
    //         ++right;
    //     }
    //     return result;
    // }
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int maxP = 0, buyTest = prices[0];
        for(int sell : prices) {
            maxP = Math.max(sell-buyTest, maxP);
            buyTest = Math.min(buyTest, sell);
        }
        return maxP;
    }
}