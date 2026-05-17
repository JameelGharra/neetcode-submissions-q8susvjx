class Solution {
    public int swimInWater(int[][] grid) {
        int res = grid[0][0], n = grid.length;
        // [elevation, i, j]
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[n][n];
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int elevation = current[0], i = current[1], j = current[2];
            res = Math.max(res, elevation);
            
            if (i == n - 1 && j == n - 1)
                return res;

            for (int[] dir : dirs) {
                int newR = i + dir[0], newC = j + dir[1];
                if (newR < 0 || newC < 0 || newR >= n || newC >= n ||
                    visited[newR][newC]) {
                        continue;
                }
                minHeap.offer(new int[]{grid[newR][newC], newR, newC});
                visited[newR][newC] = true;
            }
        }
        return -1;
    }
}
