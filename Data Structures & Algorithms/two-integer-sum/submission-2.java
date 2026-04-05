class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIdx = new HashMap<>();
        valueToIdx.put(nums[0], 0);
        for(int i = 1; i < nums.length; ++i) {
            int remainder = target-nums[i];
            if(valueToIdx.containsKey(remainder)) {
                return new int[]{valueToIdx.get(remainder), i};
            }
            valueToIdx.put(nums[i], i);
        }
        return null;
    }
}
