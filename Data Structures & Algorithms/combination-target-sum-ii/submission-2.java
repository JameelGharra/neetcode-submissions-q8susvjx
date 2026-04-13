class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] arr, int idx, int target, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return ;
        }

        if (idx == arr.length)
            return ;

        int newIdx = idx;
        while (++newIdx < arr.length && arr[newIdx] == arr[newIdx - 1]) {

        }
        if (target - arr[idx] >= 0) {
            path.add(arr[idx]);
            backtrack(arr, idx + 1, target - arr[idx], path);
            path.remove(path.size() - 1);
            backtrack(arr, newIdx, target, path);
        }
        else {
            backtrack(arr, arr.length, target, path);
        }
    }
}
