class Solution {
    public int maxArea(int[] heights) {
        int result = -1, left = 0, right = heights.length-1;
        while(left < right) {
            int storage = (right-left) * Math.min(heights[left], heights[right]);
            result = Math.max(storage, result);
            if(heights[left] < heights[right]) {
                ++left;
            }
            else {
                --right;
            }
        }
        return result;
    }
}
