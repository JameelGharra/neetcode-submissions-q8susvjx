class Solution {
    private int count;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        count = 0;
        boolean[] visited = new boolean[n];
        if (!dfs(0, -1, visited, adj)) {
            return false;
        }
        return count == n;
    }

    private boolean dfs(int nodeId, int parentId, boolean[] visited, List<List<Integer>> adj) {
        visited[nodeId] = true;
        for (int neighbour : adj.get(nodeId)) {
            if (visited[neighbour] && neighbour != parentId) {
                return false;
            }
            if (!visited[neighbour]) {
                if (!dfs(neighbour, nodeId, visited, adj))
                    return false;
            }
        }
        ++count;
        return true;
    }
}
