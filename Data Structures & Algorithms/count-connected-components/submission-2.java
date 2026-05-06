class Solution {
    // bfs
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int comps = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++comps;
                bfs(i, adj, visited);
            }
        }
        return comps;
    }
    private void bfs(int nodeId, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(nodeId);
        visited[nodeId] = true;
        while (!queue.isEmpty()) {
            int originId = queue.poll();
            for (int neighbourId : adj.get(originId)) {
                if (!visited[neighbourId]) {
                    queue.add(neighbourId);
                    visited[neighbourId] = true;
                }
            }
        }
    }
}
