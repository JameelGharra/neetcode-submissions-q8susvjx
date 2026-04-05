class Solution {
    // O(N) - O(1)
    // public int trap(int[] height) {
    //     int left = 0, right = height.length-1;
    //     int leftMax = height[left], rightMax = height[right];
    //     int result = 0;
    //     while(left < right) {
    //         if(leftMax < rightMax) {
    //             ++left;
    //             leftMax = Math.max(leftMax, height[left]);
    //             result += leftMax-height[left];
    //         }
    //         else {
    //             --right;
    //             rightMax = Math.max(rightMax, height[right]);
    //             result += rightMax-height[right];
    //         }
    //     }
    //     return result;
    // }
    // O(N) O(N)
    public int trap(int[] height) {
        if(height.length <= 1)
            return 0;
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        prefix[0] = height[0];
        suffix[height.length-1] = height[height.length-1];
        for(int i = 1; i < height.length; ++i) {
            prefix[i] = Math.max(height[i], prefix[i-1]);
        }
        for(int i = height.length-2; i >= 0; --i) {
            suffix[i] = Math.max(height[i], suffix[i+1]);
        }
        int result = 0;
        for(int i = 1; i < height.length-1; ++i) {
            result += Math.min(suffix[i], prefix[i])-height[i];
        }
        return result;
    }
}
