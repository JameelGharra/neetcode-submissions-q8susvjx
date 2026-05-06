class Solution {
    // dfs
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int comps = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++comps;
                dfs(i, adj, visited);
            }
        }
        return comps;
    }
    private void dfs(int nodeId, List<List<Integer>> adj, boolean[] visited) {
        visited[nodeId] = true;
        for (int neighbourId : adj.get(nodeId)) {
            if (!visited[neighbourId]) {
                dfs(neighbourId, adj, visited);
            }
        }
    }
}
