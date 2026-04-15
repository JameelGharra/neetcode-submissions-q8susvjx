class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    void backtrack(int[] arr, int idx, List<Integer> path) {
        if (idx == arr.length) {
            result.add(new ArrayList<>(path));
            return ;
        }
        path.add(arr[idx]);
        backtrack(arr, idx + 1, path);
        path.remove(path.size() - 1);
        int newIdx = idx + 1;
        while (newIdx < arr.length && arr[idx] == arr[newIdx]) {
            newIdx++;
        }
        backtrack(arr, newIdx, path);
    }
}
