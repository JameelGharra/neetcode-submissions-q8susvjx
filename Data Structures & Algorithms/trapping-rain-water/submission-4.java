class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    maxTrapped += leftMax - height[left];
                }
                left++;
            } else {
                // process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    maxTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return maxTrapped;
    }
}