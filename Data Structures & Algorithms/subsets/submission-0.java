class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(int idx, List<Integer> path, int[] arr) {
        if (idx == arr.length) {
            List<Integer> newList = new ArrayList<>(path);
            result.add(newList);
            return ;
        }
        path.add(arr[idx]);
        backtrack(idx + 1, path, arr);
        path.remove(path.size() - 1);
        backtrack(idx + 1, path, arr);
    }
}
