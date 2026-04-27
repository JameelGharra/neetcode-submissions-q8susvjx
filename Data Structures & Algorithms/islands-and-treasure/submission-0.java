class Solution {
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public void islandsAndTreasure(int[][] grid) {
        if (grid.length == 0)
            return ;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }
    private void bfs(int[][] grid, int i, int j) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair<Integer, Integer> originPair = new Pair<>(i, j);
        visited.add(originPair);
        queue.add(originPair);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; ++count) {
                Pair<Integer, Integer> pair = queue.poll();
                int r = pair.getKey(), c = pair.getValue();
                if (grid[r][c] != -1) {
                    grid[r][c] = Math.min(grid[r][c], level);
                    for (int[] dir : dirs) {
                        int newR = r + dir[0], newC = c + dir[1];
                        Pair<Integer, Integer> newPair = new Pair<>(newR, newC); 
                        if (newR < 0 || newC < 0 || newR >= grid.length ||
                            newC >= grid[0].length || visited.contains(newPair)) {
                            continue;
                        }
                        visited.add(newPair);
                        queue.add(newPair);
                    }
                }
            }
            ++level;
        }
    }
}
