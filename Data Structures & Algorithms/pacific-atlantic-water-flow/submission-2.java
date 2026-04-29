class Solution {
    // O(m * n) O(m * n)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            if (i == 0) {
                for (int j = 1; j < n; ++j) {
                    dfs(heights, pacific, i, j, heights[i][j]);

                }
            }
            if (i == m - 1) {
                for (int j = 0; j < n - 1; ++j) {
                    dfs(heights, atlantic, i, j, heights[i][j]);
                }
            }
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (atlantic[i][j] && pacific[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    private void dfs(int[][] heights, boolean[][] mark, int r, int c, int prev) {
        if (r < 0 || c < 0 || r == heights.length || c == heights[0].length ||
        mark[r][c] || prev > heights[r][c]) {
            return ;
        }
        mark[r][c] = true;
        dfs(heights, mark, r + 1, c, heights[r][c]);
        dfs(heights, mark, r - 1, c, heights[r][c]);
        dfs(heights, mark, r, c + 1, heights[r][c]);
        dfs(heights, mark, r, c - 1, heights[r][c]);
    }
}
