class Solution {
    // optimal weird dfs O(V + E) - O(V + E)
    private int cycleStart; // carries the node where it all started
    private boolean[] cycleMembers;
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[edges.length + 1];
        cycleMembers = new boolean[edges.length + 1];
        cycleStart = 0; // or - 1
        dfs(1, -1, adj, visited);
        for (int i = edges.length - 1; i >= 0; --i) {
            if (cycleMembers[edges[i][0]] && 
                cycleMembers[edges[i][1]]) {
                return edges[i];
            }
        }
        return null;
    }
    // if false then cycle
    private boolean dfs(int nodeId, int parentId, List<List<Integer>> adj, boolean[] visited) {
        visited[nodeId] = true;
        for (int neighbourId : adj.get(nodeId)) {
            if (parentId == neighbourId)
                continue;
            if (visited[neighbourId]) {
                cycleStart = neighbourId;
                cycleMembers[nodeId] = true;
                return false;
            }
            if (!dfs(neighbourId, nodeId, adj, visited)) {
                if (cycleStart != -1)
                    cycleMembers[nodeId] = true;
                if (cycleStart == nodeId)
                    cycleStart = -1;
                return false;
            }
        }
        return true;
    }
}
