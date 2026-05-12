class Solution {
    // Bellman-Ford naive here we go
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] time : times) {
            adjMap.computeIfAbsent(
                time[0], key -> new ArrayList<>()
            ).add(new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> distMap = new HashMap<>();
        for (int i = 1; i <= n; ++i)
            distMap.put(i, Integer.MAX_VALUE);
        // {nodeId, currDist}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), nodeId = pair[0], currDist = pair[1];
            if (distMap.get(nodeId) > currDist) {
                distMap.put(nodeId, currDist);
                if (!adjMap.containsKey(nodeId))
                    continue;
                for (int[] edge : adjMap.get(nodeId)) {
                    queue.offer(new int[]{edge[0], currDist + edge[1]});
                }
            }
        }
        int res = Collections.max(distMap.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
