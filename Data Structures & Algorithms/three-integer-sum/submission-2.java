class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-1, 0, 1, 2, -1, -4]
        // [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0) break; // since it is sorted
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = nums.length-1;
            while(left < right && right > i) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum < 0) {
                    ++left;
                }
                else if(sum > 0) {
                    --right;
                }
                else {
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    ++left;
                    --right;
                    while(left < right && nums[left-1] == nums[left])
                        ++left;
                }
            }
        }
        return result;
    }
}