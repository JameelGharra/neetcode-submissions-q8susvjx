/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        oldToNew.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node nodeToProcess = queue.poll();
            for (Node neighbor : nodeToProcess.neighbors) {
                if (oldToNew.containsKey(neighbor))
                    continue;
                oldToNew.put(neighbor, new Node(neighbor.val));
                queue.add(neighbor);
            }
        }
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Node> newNeighbors = new ArrayList<>();
            Node nodeToProcess = queue.poll();
            for (Node neighbor : nodeToProcess.neighbors) {
                newNeighbors.add(oldToNew.get(neighbor));
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            oldToNew.get(nodeToProcess).neighbors = newNeighbors;
        }
        return oldToNew.get(node);
    }
}