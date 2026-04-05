/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // map whether we created it or not
        // create by next then refer to random
        // O(n) - O(n)
        Map<Node, Node> oldToNew = new HashMap<>();
        Node curr = head, dummy = new Node(0);
        Node currNew = dummy;
        while (curr != null) {
            currNew.next = new Node(curr.val);
            currNew = currNew.next;
            oldToNew.put(curr, currNew);
            curr = curr.next;
        }
        currNew = dummy.next;
        curr = head;
        while (currNew != null) {
            currNew.random = oldToNew.get(curr.random);
            currNew = currNew.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
