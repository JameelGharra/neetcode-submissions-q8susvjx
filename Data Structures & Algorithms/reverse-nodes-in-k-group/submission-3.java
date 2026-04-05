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

// Cleaner than mine but same complexity
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevHead = dummy;
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 ----- k = 3
        while (true) {
            ListNode kth = findKth(prevHead, k);
            if (kth == null) {
                break;
            }
            ListNode curr = prevHead.next;
            ListNode prev = kth.next;
            ListNode groupNext = kth.next;
            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = prevHead.next;
            prevHead.next = kth;
            prevHead = temp;
        }
        return dummy.next;
    }

    // this works since we starting from dummy / prev group head
    private static ListNode findKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            --k;
        }
        return curr;
    }
}
