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
        int counter = 0;
        ListNode curr = head;
        while (curr != null) {
            ++counter;
            curr = curr.next;
        }
        int targetIndex = counter-n-1;
        if (targetIndex < 0) { // edge on left side
            head = head.next;
            return head;
        }
        curr = head;
        while (targetIndex != 0) {
            curr = curr.next;
            --targetIndex;
        }
        curr.next = curr.next.next;
        return head;
    }
}
