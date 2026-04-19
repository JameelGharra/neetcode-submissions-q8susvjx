class Solution {

    // it is backtracking with pruning
    // Sets for row and col checks
    // however in diag is there a way to check faster?
    private List<List<String>> res;
    private Set<Integer> cols;
    private Set<Integer> posDiag;
    private Set<Integer> negDiag;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        cols = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        backtrack(0, n, new ArrayList<>());
        return res;
    }
    
    // traverse by col but run over rows.
    // traverse by rows but run over cols
    private void backtrack(int row, int n, List<String> path) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int col = 0; col < n; ++col) {
            if (!cols.contains(col) && !posDiag.contains(row + col) &&
                !negDiag.contains(row - col)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    sb.append('.');
                }
                sb.setCharAt(col, 'Q');
                cols.add(col);
                posDiag.add(row + col);
                negDiag.add(row - col);
                path.add(sb.toString());
                backtrack(row + 1, n, path);
                path.remove(path.size() - 1);
                cols.remove(col);
                posDiag.remove(row + col);
                negDiag.remove(row - col);
            }
        }
    }
}
