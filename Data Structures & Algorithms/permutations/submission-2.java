class Solution {
    private List<List<Integer>> result;
    // backtracking too but with boolean array
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }
    private void backtrack(int[] arr, boolean[] picked, List<Integer> path) {
        if (arr.length == path.size()) {
            result.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < arr.length; ++i) {
            if (!picked[i]) {
                path.add(arr[i]);
                picked[i] = true;
                backtrack(arr, picked, path);
                path.remove(path.size() - 1);
                picked[i] = false;
            }
        }
    }
}
