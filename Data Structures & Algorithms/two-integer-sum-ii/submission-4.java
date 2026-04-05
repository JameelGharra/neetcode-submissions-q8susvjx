class Solution {
    // [1, 2, 3, 4] -> [1, 2]
    // 1-indexed result
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int currentSum = numbers[left]+numbers[right];
            if(currentSum < target) {
                left++;
            }
            else if(currentSum > target) {
                --right;
            }
            else {
                return new int[]{left+1, right+1};
            }
        }
        return null;
    }
}
