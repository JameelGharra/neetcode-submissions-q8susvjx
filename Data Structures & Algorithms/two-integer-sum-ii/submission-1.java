class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; ++i) {
            int otherNum = target-numbers[i];
            int searchedIndex = Arrays.binarySearch(numbers, otherNum);
            if(searchedIndex >= 0 && searchedIndex != i)
                return new int[]{Math.min(i, searchedIndex)+1, Math.max(i, searchedIndex)+1};
        }
        return new int[]{};
    }
}
