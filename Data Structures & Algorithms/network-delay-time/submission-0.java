class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // (V + E) * log v => E log v
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{k, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int pair[] = queue.poll(), node = pair[0], currTime = pair[1];
            if (visited.contains(node))
                continue;
            visited.add(node);
            res = currTime;
            for (int[] edge : adj.get(node)) {
                if (!visited.contains(edge[0])) {
                    queue.offer(new int[]{edge[0], currTime + edge[1]});
                }
            }
        }
        return visited.size() == n ? res : -1;
    }
}
