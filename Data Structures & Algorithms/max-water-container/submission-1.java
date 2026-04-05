class Solution {
    // O(n^2) - O(1)
    public int maxArea(int[] heights) {
        int result = -1;
        for(int i = 0 ; i < heights.length-1; ++i) {
            for(int j = i+1; j < heights.length; ++j) {
                int storage = (j-i) * Math.min(heights[i], heights[j]);
                result = Math.max(result, storage);  
            }
        }
        return result;
    }

    // O(n) - O(1)
    // public int maxArea(int[] heights) {
    //     int result = -1, left = 0, right = heights.length-1;
    //     while(left < right) {
    //         int storage = (right-left) * Math.min(heights[left], heights[right]);
    //         result = Math.max(storage, result);
    //         if(heights[left] < heights[right]) {
    //             ++left;
    //         }
    //         else {
    //             --right;
    //         }
    //     }
    //     return result;
    // }
}
