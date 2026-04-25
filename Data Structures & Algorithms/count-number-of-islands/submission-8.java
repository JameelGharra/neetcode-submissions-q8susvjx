class Solution {
    // bfs
    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}  
    };
    public int numIslands(char[][] grid) {
        int islands = 0, numRows = grid.length, numCols = grid[0].length;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] != '1') {
                    continue;
                }
                ++islands;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                grid[i][j] = '0';
                while (!queue.isEmpty()) {
                    int pair[] = queue.poll(), r = pair[0], c = pair[1];
                    for (int[] dir : dirs) {
                        int newR = r  + dir[0], newC = c + dir[1];
                        if (newR < 0 || newC < 0 || newR >= numRows ||
                            newC >= numCols || grid[newR][newC] != '1'
                        ) {
                            continue;        
                        }
                        queue.add(new int[]{newR, newC});   
                        grid[newR][newC] = '0';
                    }
                }
            }
        }
        return islands;
    }
}
