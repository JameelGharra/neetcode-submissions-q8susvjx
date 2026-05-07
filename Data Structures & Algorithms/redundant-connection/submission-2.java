class Solution {
    // union find O(V + E * alpha(V)) O(V)
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] res = null;
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                res = edge;
        }
        return res;
    }
    private static class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        int find(int x) {
            if (x == parent[x])
                return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return false;
            if (rank[rootX] == rank[rootY]) {
                ++rank[rootX];
            }
            else if (rank[rootX] < rank[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            return true;
        }
    }
}
