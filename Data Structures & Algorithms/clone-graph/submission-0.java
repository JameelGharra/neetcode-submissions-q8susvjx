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
        return dfs(node, oldToNew);
    }
    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);
        List<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            if (!oldToNew.containsKey(neighbor)) {
                newNeighbors.add(dfs(neighbor, oldToNew));
            }
            else {
                newNeighbors.add(oldToNew.get(neighbor));
            }
        }
        newNode.neighbors = newNeighbors;
        return newNode;
    }
}