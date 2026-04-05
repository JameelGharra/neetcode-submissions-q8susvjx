class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        int left = 0;
        for(int right = k-1; right <= nums.length-1; ++right) {
            int currentMax = nums[left];
            for(int i = left+1; i <= right; ++i)
                currentMax = Math.max(currentMax, nums[i]);
            result[left] = currentMax;
            ++left;
        }
        return result;
    }
}
