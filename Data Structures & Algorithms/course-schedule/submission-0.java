class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            edges.add(new ArrayList<>());
        // [0, 1] is 1 -> 0 ... must take 1 before 0
        for (int[] prereq : prerequisites) {
            ++inDegree[prereq[0]];
            edges.get(prereq[1]).add(prereq[0]);
        }
        for (int i = 0; i < numCourses; ++i)
            if (inDegree[i] == 0)
                queue.add(i);
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int courseId = queue.poll();            
            for (int neighborCourseId : edges.get(courseId)) {
                --inDegree[neighborCourseId];
                if (inDegree[neighborCourseId] == 0)
                    queue.add(neighborCourseId);
            }
        }
        return visited == numCourses;
    }
}
