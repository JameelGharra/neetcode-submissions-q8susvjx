class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    // we do not need a path parameter although it works
    private void backtrack(int[] arr, int idx) {
        if (idx == arr.length) {
            List<Integer> path = new ArrayList<>();
            for (int elem : arr) {
                path.add(elem);
            }
            res.add(path);
            return ;
        }
        for (int i = idx; i < arr.length; ++i) {
            swap(arr, idx, i);
            backtrack(arr, idx + 1);
            swap(arr, idx, i);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
