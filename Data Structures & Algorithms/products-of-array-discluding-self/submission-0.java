class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 31, 2, 41, 442, 95
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prevLeft = 1, prevRight = 1;
        for(int i = 0, j = nums.length-1; i < nums.length; ++i, --j) {
            right[j] = prevRight*nums[j];
            prevRight = right[j];
            left[i] = prevLeft*nums[i];
            prevLeft = left[i];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; ++i) {
            int l = 1, r = 1;
            if(i > 0)
                l = left[i-1];
            if(i < nums.length-1)
                r = right[i+1];

            result[i] = l*r;
        }
        return result;
    }
}  
