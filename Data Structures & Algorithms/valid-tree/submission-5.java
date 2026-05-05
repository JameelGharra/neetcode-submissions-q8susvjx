class Solution {
    // disjoint, whats good is that we dont need to build adjacency list
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return false;
        }
        return uf.size[uf.parent[0]] == n;
        // return true;
    }
    private static class UnionFind {
        int[] parent;
        int[] size;
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
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
                size[rootX] += size[rootY];
                parent[rootY] = rootX;
            }
            else {
                size[rootY] += size[rootX];
                parent[rootX] = rootY;
            }
            return true;
        }
    }
}
