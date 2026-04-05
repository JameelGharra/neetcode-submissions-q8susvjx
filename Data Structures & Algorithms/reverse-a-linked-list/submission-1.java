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
    // current.next.next = current
    // current = faster;
    // we do not want faster to be null
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode current = head, faster, prev = null, newPrev;
        // [3, 2, 1, 5, 2 -> null]
        while(current != null && current.next != null) {
            faster = current.next.next;
            current.next.next = current;
            newPrev = current.next;
            current.next = prev;
            prev = newPrev;
            current = faster;
        }
        if(current != null) // odd
            current.next = prev;
        else
            current = prev;
        return current;
    }
}
