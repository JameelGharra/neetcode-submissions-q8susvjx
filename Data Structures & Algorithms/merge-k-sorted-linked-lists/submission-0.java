/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // O(k) space - O(n * k) time
    // where k number of lists and n number of total nodes
    public ListNode mergeKLists(ListNode[] lists) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode dummy = new ListNode(), curr = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                nodes.add(node);
            }
        }
        while (nodes.size() > 0) {
            ListNode currMinNode = null;
            for (ListNode node : nodes) {
                if (currMinNode == null || currMinNode.val > node.val) {
                    currMinNode = node;
                }
            }
            nodes.remove(currMinNode);
            if (currMinNode.next != null) {
                nodes.add(currMinNode.next);
            }
            curr.next = currMinNode;
            curr = currMinNode;
        }
        return dummy.next;
    }
}
