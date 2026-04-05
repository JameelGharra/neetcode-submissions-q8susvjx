class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int currentArea, maxArea = 0;
        while(left < right) {
            currentArea = (right-left)*Math.min(heights[left], heights[right]);
            maxArea = Math.max(currentArea, maxArea);
            if(heights[left] < heights[right]) {
                ++left;
            }
            else {
                --right;
            }
        }
        return maxArea;
    }
}
