class Solution {
    // dfs
    // I think that the problem reduces to whether the graph contains a cycle
    // or not
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());
        // [a, b]: b -> a
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        for (int i = 0 ; i < numCourses; ++i) {
            if (!visited[i] && !dfs(i, adj, inPath, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int nodeId, List<List<Integer>> adj, boolean[] inPath, boolean[] visited) {
        inPath[nodeId] = true;
        for (int neighbor : adj.get(nodeId)) {
            if (inPath[neighbor] || !dfs(neighbor, adj, inPath, visited))
                return false;
        }
        inPath[nodeId] = false;
        visited[nodeId] = true;
        return true;
    }
}
