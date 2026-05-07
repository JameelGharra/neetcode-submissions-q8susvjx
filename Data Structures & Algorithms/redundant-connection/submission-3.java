class Solution {
    // union find O(V + E * alpha(V)) O(V)
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                // ik in question they said "multiple answers"
                // but remember the original graph had no cycles
                // so the moment we reach a cycle it has to be the
                // extra added edge
                return edge; 
        }
        return null;
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
