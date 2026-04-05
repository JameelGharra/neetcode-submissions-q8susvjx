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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // reverse
        // iterate and keep prev
        // reverse

        ListNode curr = head, prev = null;
        int counter = 0;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            counter++;
        }
        head = prev;
        ListNode newHead = prev;
        prev = null;
        while (n != 1) {
            prev = head;
            --n;
            head = head.next;
        }
        // editing
        if (prev != null) { // in between
            prev.next = head.next;
        }
        else if (counter > 1) { // on edge
            newHead = head.next;
        }
        else { // empty list
            return null;
        }
        prev = null;
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = temp;
        }
        return prev;
    }
}
