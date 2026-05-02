class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        // [a, b]: b -> a
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            ++inDegree[pre[0]];
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int courseId = queue.poll();
            res.add(courseId);
            for (int neighbour : adj.get(courseId)) {
                --inDegree[neighbour];
                if (inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        if (res.size() != numCourses)
            return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
