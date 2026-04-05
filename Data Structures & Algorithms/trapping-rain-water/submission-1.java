class Solution {
    // O(n^2) - O(1)
    public int trap(int[] height) {
        if(height.length <= 1)
            return 0;
        int result = 0;
        for(int i = 1; i < height.length; ++i) {
            int leftMax = height[i];
            for(int j = 0; j < i; ++j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = height[i];
            for(int j = height.length-1; j > i; --j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }
    // prefix, suffix O(n) - O(n)
    // public int trap(int[] height) {
    //     if(height.length == 1)
    //         return 0;

    //     int[] prefix = new int[height.length];
    //     int[] suffix = new int[height.length];
    //     prefix[0] = height[0];
    //     suffix[height.length-1] = height[height.length-1];
    //     for(int i = 1; i < height.length; ++i) {
    //         prefix[i] = Math.max(prefix[i-1], height[i]);
    //     }
    //     for(int i = height.length-2; i >= 0; --i) {
    //         suffix[i] = Math.max(suffix[i+1], height[i]);
    //     }
    //     int result = 0;
    //     for(int i = 1; i < height.length-1; ++i) {
    //         result += Math.min(prefix[i], suffix[i])-height[i];
    //     }
    //     return result;
    // }
    // O(n) - O(1)
    // public int trap(int[] height) {
    //     if(height.length <= 1)
    //         return 0;

    //     int left = 0, right = height.length-1;
    //     int leftMax = height[0], rightMax = height[height.length-1];
    //     int result = 0;
    //     while(left < right) {
    //         if(leftMax < rightMax) {
    //             ++left;
    //             leftMax = Math.max(height[left], leftMax);
    //             result += leftMax-height[left];
    //         }
    //         else {
    //             --right;
    //             rightMax = Math.max(height[right], rightMax);
    //             result += rightMax-height[right];
    //         }
    //     }
    //     return result;
    // }
}
