class Solution {
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ++fresh;
                }
                else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isChanged = false;
            for (int i = 0; i < size; ++i) {
                int[] pair = queue.poll();
                for (int[] dir : dirs) {
                    int newR = pair[0] + dir[0], newC = pair[1] + dir[1];
                    if (newR < 0 || newC < 0 || newR >= grid.length ||
                        newC >= grid[0].length || grid[newR][newC] != 1) {
                        continue;
                    }
                    grid[newR][newC] = 2;
                    isChanged = true;
                    --fresh;
                    queue.add(new int[]{newR, newC});
                }
            }
            if (isChanged)
                ++minutes;
        }
        return fresh == 0 ? minutes : -1;
    }
}
