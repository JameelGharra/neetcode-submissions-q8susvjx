class Solution {
    public int longestConsecutive(int[] nums) {
        //[2,20,4,10,3,4,5]
        int[] copiedArr = Arrays.stream(nums).toArray();
        Arrays.sort(copiedArr);
        int result = 0, index = 0;
        while(index < nums.length) {
            int currentLen = 1;
            while(index+1 < nums.length && copiedArr[index]+1 == copiedArr[index+1]) {
                ++currentLen;
                ++index;
                while(index+1 < nums.length && copiedArr[index]==copiedArr[index+1]) {
                    ++index;
                }
            }
            result = Math.max(result, currentLen);
            ++index;
        }
        return result;
    }
}
