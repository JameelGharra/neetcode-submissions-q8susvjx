class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int idx, int target, List<Integer> path) {
        if (target < 0 || idx == nums.length) {
            return ;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return ;
        }
        path.add(nums[idx]);
        backtrack(nums, idx, target - nums[idx], path);
        // this call led to duplicate lists
        // for e.g. idx (added) -> idx + 1 (skip) OR idx + 1 (added)
        // backtrack(nums, idx + 1, target - nums[idx], path);
        path.remove(path.size() - 1);
        backtrack(nums, idx + 1, target, path);
    }
}
