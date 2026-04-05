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
    // interleaving no need hashmap
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node currNew = new Node(curr.val);
            Node temp = curr.next;
            curr.next = currNew;
            currNew.next = temp;
            curr = temp;
        }
        curr = head;
        while (curr != null) {
            Node currNew = curr.next;
            if (curr.random != null)
                currNew.random = curr.random.next;
            curr = curr.next.next;
        }
        Node newHead = head.next;
        curr = head;
        while (curr != null) {
            // A -> A' -> B -> B' -> C
            Node currNew = curr.next;
            curr.next = currNew.next;
            if (currNew.next != null) {
                currNew.next = currNew.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }
}
