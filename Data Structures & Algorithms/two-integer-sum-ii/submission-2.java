class Solution {
    // O(n log n) - O(1)
    // public int[] twoSum(int[] numbers, int target) {
    //     for(int i = 0; i < numbers.length; ++i) {
    //         int otherNum = target-numbers[i];
    //         int searchedIndex = Arrays.binarySearch(numbers, otherNum);
    //         if(searchedIndex >= 0 && searchedIndex != i)
    //             return new int[]{Math.min(i, searchedIndex)+1, Math.max(i, searchedIndex)+1};
    //     }
    //     return new int[]{};
    // }

    // O(n) - O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int sum = numbers[left]+numbers[right];
            if(sum < target)
                ++left;
            else if(sum > target)
                --right;
            else
                return new int[]{left+1, right+1};
        }
        return null;
    }
}
