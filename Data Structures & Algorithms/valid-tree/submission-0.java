class Solution {
    private List<Integer> res;
    public boolean validTree(int n, int[][] edges) {
        int[] states = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        res = new ArrayList<>();
        if (!dfs(0, -1, states, adj)) {
            return false;
        }
        return res.size() == n;
    }

    private boolean dfs(int nodeId, int parentId, int[] states, List<List<Integer>> adj) {
        states[nodeId] = 1;
        for (int neighbour : adj.get(nodeId)) {
            if (states[neighbour] == 1 && neighbour != parentId) {
                return false;
            }
            if (states[neighbour] == 0) {
                if (!dfs(neighbour, nodeId, states, adj))
                    return false;
            }
        }
        res.add(nodeId);
        states[nodeId] = 2;
        return true;
    }
}
