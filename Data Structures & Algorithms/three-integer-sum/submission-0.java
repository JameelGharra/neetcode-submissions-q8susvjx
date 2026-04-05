class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-1, 0, 1, 2, -1, -4]
        // [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i) {
            int left = i+1, right = nums.length-1;
            int partialTarget = -1*nums[i];
            while(left < right && right > i) {
                int sum = nums[left]+nums[right];
                if(sum < partialTarget) {
                    ++left;
                }
                else if(sum > partialTarget) {
                    --right;
                }
                else {
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left+1])
                        ++left;
                    while(i < right && nums[right] == nums[right-1])
                        --right;
                    ++left;
                    --right;
                }
            }
            while(i < nums.length-1 && nums[i] == nums[i+1])
                ++i;
        }
        return result;
    }
}