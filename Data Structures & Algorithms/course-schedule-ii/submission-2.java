class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        // [a, b] => b -> a 
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (states[i] != 2) {
                if (!dfs(i, states, adj, stack)) {
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }
    private boolean dfs(int nodeId, int[] states, List<List<Integer>> adj, Stack<Integer> stack) {
        if (states[nodeId] == 1)
            return false;
        if (states[nodeId] == 2)
            return true;
        states[nodeId] = 1;
        for (int neighbour : adj.get(nodeId)) {
            if (!dfs(neighbour, states, adj, stack))
                return false;
        }
        states[nodeId] = 2;
        stack.push(nodeId);
        return true;
    }
}
