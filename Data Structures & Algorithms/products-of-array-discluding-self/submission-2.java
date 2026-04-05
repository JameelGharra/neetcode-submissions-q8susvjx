class Solution {
    // O(N) time - O(N) space
    // public int[] productExceptSelf(int[] nums) {
    //     // 31, 2, 41, 442, 95
    //     int[] left = new int[nums.length];
    //     int[] right = new int[nums.length];
    //     int prevLeft = 1, prevRight = 1;
    //     for(int i = 0, j = nums.length-1; i < nums.length; ++i, --j) {
    //         right[j] = prevRight*nums[j];
    //         prevRight = right[j];
    //         left[i] = prevLeft*nums[i];
    //         prevLeft = left[i];
    //     }
    //     int[] result = new int[nums.length];
    //     for(int i = 0; i < result.length; ++i) {
    //         int l = 1, r = 1;
    //         if(i > 0)
    //             l = left[i-1];
    //         if(i < nums.length-1)
    //             r = right[i+1];

    //         result[i] = l*r;
    //     }
    //     return result;
    // }

    // Two pass: O(N) time - O(1) space
    // 34, 2, 98, 101, 500
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int post = 1;
        result[0] = 1;
        for(int i = 1; i < nums.length; ++i) {
            result[i] = result[i-1]*nums[i-1];
        }
        for(int j = nums.length-1; j >= 0; --j) {
            result[j] *= post;
            post *= nums[j]; 
        }
        return result;
    }
}  
