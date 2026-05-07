class Solution {
    // topological sort (leaf trimming)
    public int[] findRedundantConnection(int[][] edges) {
        int[] standardDeg = new int[edges.length + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            ++standardDeg[edge[0]];
            ++standardDeg[edge[1]];
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= edges.length; ++i) {
            if (standardDeg[i] == 1)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            --standardDeg[nodeId];
            for (int neighbourId : adj.get(nodeId)) {
                --standardDeg[neighbourId];
                if (standardDeg[neighbourId] == 1)
                    queue.add(neighbourId);
            }
        }
        for (int i = edges.length - 1; i >= 0; --i) {
            if (standardDeg[edges[i][0]] == 2 && 
                standardDeg[edges[i][1]] == 2) {
                return edges[i];
            }
        }
        return null;
    }
}