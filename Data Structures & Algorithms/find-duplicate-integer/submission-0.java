class Solution {
    // sorting O(n log n) - O(n) if not in-place
    // hashset ... O(n) - O(n)
    // O(n^2) brute-force
    // O(n) - O(1)
    // 1, 2, 3, .... , n
    // public int findDuplicate(int[] nums) {
    //     Set<Integer> seen = new HashSet<>();
    //     for (int num : nums) {
    //         if (!seen.add(num))
    //             return num;
    //     }
    //     return 0;
    // }
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int number = Math.abs(nums[i]);
            if (nums[number] < 0)
                return number;
            nums[number] *= -1;
        }
        return 0;
    }
}
