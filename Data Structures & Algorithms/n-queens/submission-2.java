class Solution {
    // I realized I need to decouple the algorithm state (what I need to make
    // recursive decisions) and output format (problemr return).
    // The decoupling would make the internal backtracking logic lightning-fast
    // and memory efficient
    // so building the string at the end would optimize the code (since we prune)
    private List<List<String>> res;
    private Set<Integer> cols;
    private Set<Integer> negDiag;
    private Set<Integer> posDiag;

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        res = new ArrayList<>();
        cols = new HashSet<>();
        negDiag = new HashSet<>();
        posDiag = new HashSet<>();
        backtrack(0, queens);
        return res;
    }

    private void backtrack(int row, int[] queens) {
        if (row == queens.length) {
            res.add(buildBoard(queens));
            return ;
        }
        for (int col = 0; col < queens.length; ++col) {
            if (!cols.contains(col) && !posDiag.contains(row + col) &&
            !negDiag.contains(row - col)) {
                queens[row] = col;
                cols.add(col);
                posDiag.add(row + col);
                negDiag.add(row - col);
                backtrack(row + 1, queens);
                cols.remove(col);
                posDiag.remove(row + col);
                negDiag.remove(row - col);
            }
        }
    }

    private List<String> buildBoard(int[] queens) {
        StringBuilder sb = new StringBuilder();
        List<String> boardState = new ArrayList<>();
        for (int i = 0; i < queens.length; ++i)
            sb.append('.');
        for (int i = 0; i < queens.length; ++i) {
            sb.setCharAt(queens[i], 'Q');
            boardState.add(sb.toString());
            sb.setCharAt(queens[i], '.');
        }
        return boardState;
    }
}
