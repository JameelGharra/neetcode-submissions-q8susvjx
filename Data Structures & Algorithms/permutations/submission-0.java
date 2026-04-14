class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] arr, int idx, List<Integer> path) {
        if (idx == arr.length) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = idx; i < arr.length; ++i) {
            swap(arr, idx, i);
            path.add(arr[idx]);
            backtrack(arr, idx + 1, path);
            path.remove(path.size() - 1);
            swap(arr, idx, i);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
