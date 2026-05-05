class Solution {
    // bfs same concept
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
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, -1});
        int count = 1;
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), nodeId = pair[0], parentId = pair[1];
            for (int neighbourId : adj.get(nodeId)) {
                if (parentId == neighbourId)
                    continue;
                if (visited[neighbourId])
                    return false;
                queue.add(new int[]{neighbourId, nodeId});
                ++count;
                visited[neighbourId] = true;
            }
        }
        return count == n;
    }
}
