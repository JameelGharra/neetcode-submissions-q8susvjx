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
            List<Node> eqNodeNeighbors = oldToNew.get(nodeToProcess).neighbors;
            for (Node neighbor : nodeToProcess.neighbors) {
                if (oldToNew.containsKey(neighbor)) {
                    eqNodeNeighbors.add(oldToNew.get(neighbor));
                    continue;
                }
                Node newNeighbor = new Node(neighbor.val);
                oldToNew.put(neighbor, newNeighbor);
                eqNodeNeighbors.add(newNeighbor);
                queue.add(neighbor);
            }
        }
        return oldToNew.get(node);
    }
}