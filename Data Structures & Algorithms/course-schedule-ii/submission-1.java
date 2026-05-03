public class Solution {

    // Simulating an adjacency list graph: Map<Node, List<Neighbors>>
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            // pre[1] must be taken before pre[0]: pre[1] -> pre[0]
            adjList.get(pre[1]).add(pre[0]);
        }

        // 2. Initialize state tracking and the result stack
        // states: 0 = unvisited, 1 = visiting, 2 = visited
        int[] states = new int[numCourses]; 
        Stack<Integer> stack = new Stack<>();

        // 3. Run DFS on every unvisited node
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                // If DFS returns false, a cycle was detected!
                if (!dfs(i, adjList, states, stack)) {
                    return new int[0]; // Empty array indicates impossible to finish
                }
            }
        }

        // 4. Pop everything off the stack to get the topological order
        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adjList, int[] states, Stack<Integer> stack) {
        // Mark the current node as VISITING (1)
        states[node] = 1;

        // Explore all neighbors
        for (int neighbor : adjList.get(node)) {
            if (states[neighbor] == 1) {
                // Cycle detected! The neighbor is already in our current DFS path.
                return false; 
            }
            if (states[neighbor] == 0) {
                // If it's unvisited, recurse. If the deeper call finds a cycle, propagate the failure up.
                if (!dfs(neighbor, adjList, states, stack)) {
                    return false;
                }
            }
            // If states[neighbor] == 2, it's already fully processed, so we just skip it.
        }

        // Once all neighbors are processed, mark as VISITED (2)
        states[node] = 2;
        // Push to stack because its finish time is now complete
        stack.push(node);

        return true; 
    }
}