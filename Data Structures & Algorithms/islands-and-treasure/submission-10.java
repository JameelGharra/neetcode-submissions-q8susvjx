class Solution {
    // this solution is dfs but smarter with pruning
    // this makes the time O(v^2) since each cell can be updated
    // up to v times (distance v, distance v-1, ... distance 1)
    // space still O(v) recursion stack
    // where v is number of cells
    public void islandsAndTreasure(int[][] grid) {
        // Iterate and start a DFS ONLY from the treasures
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int dist) {
        // Base cases: bounds check OR our elegant pruning condition
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] < dist) {
            return;
        }

        // Update the current cell with the strictly smaller distance
        grid[r][c] = dist;

        // Radiate outward, incrementing distance
        dfs(grid, r + 1, c, dist + 1);
        dfs(grid, r - 1, c, dist + 1);
        dfs(grid, r, c + 1, dist + 1);
        dfs(grid, r, c - 1, dist + 1);
    }
}