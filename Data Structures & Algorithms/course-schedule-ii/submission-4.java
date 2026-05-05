class Solution {
    // same as before but without stack trick
    // to avoid another extra O(V) but would not change complexities
    private int index;
    private int[] res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        // [a, b] => b -> a 
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        index = numCourses - 1;
        res = new int[numCourses];
        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (states[i] == 0) {
                if (!dfs(i, states, adj)) {
                    return new int[0];
                }
            }
        }
        
        return res;
    }
    private boolean dfs(int nodeId, int[] states, List<List<Integer>> adj) {
        states[nodeId] = 1;
        for (int neighbour : adj.get(nodeId)) {
            if (states[neighbour] == 1)
                return false;
            if (states[neighbour] == 0) {
                if (!dfs(neighbour, states, adj))
                    return false;
            }
        }
        states[nodeId] = 2;
        res[index--] = nodeId;
        return true;
    }
}
