class Solution {
    private List<List<Integer>> result;
    // same optimal just cleaner
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] arr, int target, int idx, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int j = idx; j < arr.length; ++j) {

            if (j > idx && arr[j] == arr[j - 1]) {
                continue;
            }
            if (target - arr[j] < 0) {
                break;
            }
            path.add(arr[j]);
            backtrack(arr, target - arr[j], j + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
