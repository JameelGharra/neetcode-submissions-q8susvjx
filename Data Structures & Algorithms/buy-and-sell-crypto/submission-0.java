class Solution {
    // O(n^2) - O(1)
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0; i < prices.length-1; ++i) {
            for(int j = i+1; j < prices.length; ++j) {
                result = Math.max(result, prices[j]-prices[i]);
            }
        }
        return result;
    }
}