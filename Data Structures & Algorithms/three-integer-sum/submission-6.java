class Solution {
    // [-1,0,1,2,-1,-4]
    // [-4, -1, -1, 0, 1, 2]
    // Output: [[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)
            return null;
        Arrays.sort(nums);
        int left, right;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; ++i) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] > 0)
                break;
            left = i+1;
            right = nums.length-1;
            while(left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum > 0) {
                    --right;
                }
                else if(sum < 0) {
                    left++;
                }
                else {
                    List<Integer> newList = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(newList);
                    left++;
                    --right;
                    while(left < right && nums[left-1] == nums[left]) {
                        ++left;
                    }
                    while(left < right && nums[right] == nums[right+1]) {
                        --right;
                    }
                }
            }
        }
        return result;
    }
}
