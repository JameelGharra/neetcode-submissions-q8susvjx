class Solution {
    // dfs incremental build - O(E * (V + E)) O(V + E)
    // which is with the constraints O(V^2) - O(V)
    // since we know there are n nodes and n edges
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[edges.length + 1];
            if (!dfs(edge[0], -1, visited, adj))
                return edge;
        }
        return null;
    }
    private boolean dfs(int id, int pId, boolean[] visited, List<List<Integer>> adj) {
        visited[id] = true;
        for (int nid : adj.get(id)) {
            if (nid == pId)
                continue;
            if (visited[nid]) {
                return false;
            }
            dfs(nid, id, visited, adj);
        }
        return true;
    }
}
