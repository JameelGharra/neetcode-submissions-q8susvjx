class Solution {
    private List<List<Integer>> result;
    // optimal backtracking
    // realistically this is infinitely faster in real-world however asymptotically
    // time is O(t / M * N ^ (t / M)), yes no + N for the skipping part like
    // previous solution, since skipping happens in the same stack frame by
    // advancing ++j;
    // auxiliary space is O(t / M) for same reason why there is no + N.
    // output space overall space comp O(t / M * N ^ (t / M))
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int target, List<Integer> path, int idx) {
        for (int j = idx; j < nums.length; ++j) {
            if (target - nums[j] < 0) {
                return ;
            }
            path.add(nums[j]);
            if (target - nums[j] == 0) {
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return ;
            }
            backtrack(nums, target - nums[j], path, j);
            path.remove(path.size() - 1);
        }
    }
}
