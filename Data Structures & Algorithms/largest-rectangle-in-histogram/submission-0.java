class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // (index, height)
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i) {
            // no further extensions allowed
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();
                int area = (i-pair[0]) * pair[1];
                maxArea = Math.max(maxArea, area); 
                start = pair[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        while(!stack.isEmpty()) {
            int[] pair = stack.pop();
            int area = (heights.length-pair[0])*pair[1];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
