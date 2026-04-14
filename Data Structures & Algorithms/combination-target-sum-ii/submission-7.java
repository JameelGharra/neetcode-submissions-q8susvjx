class Solution {
    private List<List<Integer>> result;
    // same optimal just cleaner
    // global state vs. passed state for result class member idk but its ok imo
    // another thing we did not say that time is O(n * n^n) here for example
    // despite the fact in previous problem we did say something like that
    // cause here, we do the next call on idx + 1 at least, whereas previously
    // we called in the same index, so there is a chance that branching factor
    // there won't shrink like here, here it definitely shrinks as we go down tree
    // so time complexity remains the same as non-iterative solution
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
