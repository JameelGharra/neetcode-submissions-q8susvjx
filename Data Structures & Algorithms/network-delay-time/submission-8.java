class Solution {
    // BFS
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
        distMap.put(k, 0);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), nodeId = pair[0], currDist = pair[1];
            if (currDist > distMap.get(nodeId))
                continue;
            if (!adjMap.containsKey(nodeId))
                continue;
            for (int[] edge : adjMap.get(nodeId)) {
                int newDist = currDist + edge[1];
                if (newDist < distMap.get(edge[0])) {
                    distMap.put(edge[0], newDist);
                    queue.offer(new int[]{edge[0], newDist});
                }
            }
        }
        int res = Collections.max(distMap.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
