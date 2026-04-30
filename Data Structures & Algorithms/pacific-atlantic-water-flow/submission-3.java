class Solution {
    // same same just not look like an idiot
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; ++i) {
            dfs(pacific, heights, i, 0, heights[i][0]);
            dfs(atlantic, heights, i, COLS - 1, heights[i][COLS - 1]);
        }
        for (int j = 0; j < COLS; ++j) {
            dfs(pacific, heights, 0, j, heights[0][j]);
            dfs(atlantic, heights, ROWS - 1, j, heights[ROWS - 1][j]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] mark, int[][] heights, int r, int c, int prev) {
        if (r < 0 || c < 0 || r == mark.length || c == mark[0].length ||
            mark[r][c] || prev > heights[r][c]) {
            return ;
        }
        mark[r][c] = true;
        dfs(mark, heights, r + 1, c, heights[r][c]);
        dfs(mark, heights, r - 1, c, heights[r][c]);
        dfs(mark, heights, r, c + 1, heights[r][c]);
        dfs(mark, heights, r, c - 1, heights[r][c]);
    }
}
