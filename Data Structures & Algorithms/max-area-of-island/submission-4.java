class Solution {
    // UF
    private static final int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int atLeastOne = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    atLeastOne = 1; 
                    for (int[] dir : dirs) {
                        int newR = i + dir[0], newC = j + dir[1];
                        if (newR < 0 || newC < 0 || newR >= m || newC >= n ||
                        grid[newR][newC] != 1) {
                            continue;
                        }
                        uf.union(
                            i * n + j,
                            newR * n + newC
                        );
                    }
                }
            }
        }
        return Math.max(uf.maxSize, atLeastOne);
    }

    private static class UnionFind {
        int[] size;
        int[] parent;
        int maxSize = 0;

        UnionFind(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return false;

            if (size[rootX] >= size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);

            }
            else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                maxSize = Math.max(maxSize, size[rootY]);
            }
            return true;
        }
    }
}
