class Solution {
    // for practice, do dfs version
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        // In form of nodeId -> [neighbourId, weight]
        for (int[] edge : times) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>())
            .add(new int[]{edge[1], edge[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; ++i)
            dist.put(i, Integer.MAX_VALUE);
        dfs(k, 0, adj, dist);
        int res = Collections.max(dist.values());
        return res != Integer.MAX_VALUE ? res : -1;
    }
    private void dfs(int nodeId, 
                     int time, Map<Integer, List<int[]>> adj, 
                     Map<Integer, Integer> dist) {
        if (dist.get(nodeId) <= time)
            return ;
        dist.put(nodeId, time);
        if (!adj.containsKey(nodeId))
            return ;
        for (int[] neighbour : adj.get(nodeId)) {
            dfs(neighbour[0], time + neighbour[1], adj, dist);
        }
    }
}
