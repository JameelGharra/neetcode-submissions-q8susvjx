class Solution {
    private List<List<Integer>> result;
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
        if (idx == arr.length)
            return ;
        for (int j = idx; j < arr.length; ++j) {
            int newIdx = j;
            while (++newIdx < arr.length && arr[newIdx] == arr[newIdx - 1]);
            
            if (target - arr[j] >= 0) {
                path.add(arr[j]);
                backtrack(arr, target - arr[j], j + 1, path);
                path.remove(path.size() - 1);
            }
            else {
                return;
            }
            j = newIdx - 1;
        }
    }
}
