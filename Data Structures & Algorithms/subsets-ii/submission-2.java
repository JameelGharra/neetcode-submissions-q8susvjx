class Solution {
    // backtracking but for-loop style
    private List<List<Integer>> result;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] arr, int idx, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = idx; i < arr.length; ++i) {
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }
            path.add(arr[i]);
            backtrack(arr, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
