class Solution {
    // [2,20,4,4,5,5,10,3,4,5]
    // [1,2,2,3,4,5,5,6,7,12]
    // sort -> count then reset if 'block' > 1 nlogn
    // O(N log N) - O(N) for temp if not O(1)
    // public int longestConsecutive(int[] nums) {
    //     if(nums.length == 0)
    //         return 0;

    //     int[] temp;
    //     temp = Arrays.copyOf(nums, nums.length);
    //     Arrays.sort(temp);
    //     int maxStreak = 1, currentStreak = 1;
    //     for(int i = 1; i < temp.length; ++i) {
    //         if(temp[i-1]+1 == temp[i]) {
    //             currentStreak++;
    //         }
    //         else if(temp[i-1]+1 < temp[i]) {
    //             maxStreak = Math.max(maxStreak, currentStreak);
    //             currentStreak = 1;
    //         } 
    //     }
    //     maxStreak = Math.max(maxStreak, currentStreak);
    //     return maxStreak;
    // }
    // set approach 
    // [2,20,4,4,5,5,10,3,4,5]
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        // find minimum then go upwards if break say bye
        Set<Integer> numbers = new HashSet<>();
        for(Integer number : nums) {
            numbers.add(number);
        }
        int currentStreak = 0, currentMinimum, maxStreak = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(!numbers.contains(nums[i])) {
                continue;
            }
            currentMinimum = nums[i];
            while(numbers.contains(currentMinimum-1)) {
                currentMinimum--;
            }
            while(numbers.remove(currentMinimum)) {
                currentMinimum++;
                currentStreak++;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
            currentStreak = 0;
        }
        return maxStreak;
    }
}