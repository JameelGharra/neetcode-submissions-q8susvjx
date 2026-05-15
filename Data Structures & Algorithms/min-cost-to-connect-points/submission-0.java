class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < points.length; ++i)
            adj.add(new ArrayList<>());
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                int weight = 
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, weight});
                adj.get(j).add(new int[]{i, weight});
            }
        }
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{0, 0});
        int totalCost = 0;
        while (!minHeap.isEmpty() && visited.size() < points.length) {
            int[] pair = minHeap.poll();
            int currNode = pair[0], weight = pair[1];
            if (visited.contains(currNode))
                continue;
            visited.add(currNode);
            totalCost += weight;
            for (int[] neighbour : adj.get(currNode)) {
                minHeap.offer(new int[]{neighbour[0], neighbour[1]});
            }
        }
        return totalCost;
    }
}
