class Solution {
    // O(n) time (two pass) - O(1) space
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int[] result = new int[nums.length];
        result[0] = 1;
        result[nums.length-1] = 1;
        for(int i = 1; i < nums.length; ++i) {
            left = left * nums[i-1];
            result[i] = left;
        }
        for(int i = nums.length-2; i >= 0; --i) {
            right = right * nums[i+1];
            result[i] = result[i] * right;
        }
        return result;
    }
}  
