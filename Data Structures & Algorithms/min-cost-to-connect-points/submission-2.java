class Solution {
    // O(n^2) time
    public int minCostConnectPoints(int[][] points) {
        int totalCost = 0, n = points.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 10000000);
        int edges = 0, node = 0;
        while (edges < n - 1) {
            visited[node] = true;
            int nextNode = -1;
            for (int i = 0; i < n; ++i) {
                if (visited[i])
                    continue;
                int weight = Math.abs(points[node][0] - points[i][0]) + 
                             Math.abs(points[node][1] - points[i][1]);
                dist[i] = Math.min(weight, dist[i]);
                if (nextNode == -1 || dist[i] < dist[nextNode])
                    nextNode = i;
            }
            totalCost += dist[nextNode];
            node = nextNode;
            ++edges;
        }
        return totalCost;
    }
}
