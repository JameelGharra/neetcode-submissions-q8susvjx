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
    public ListNode reverseKGroup(ListNode head, int k) {
        // count nodes say n
        // d = n % k
        // n - d terminate if reached (dont include that in)
        // advance in k and when reached, reset

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            ++len;
        }
        int terminateIdx = len - (len % k);
        int steps = 0;
        curr = head;
        ListNode prevHead = null;
        ListNode res = head;
        while (steps != terminateIdx) {
            int counter = 0;
            ListNode groupHead = curr;
            while (counter != k) {
                curr = curr.next;
                ++counter;
            }
            ListNode iterate = groupHead;
            ListNode prev = null;
            // until reaches the next group
            counter = 0;
            while (iterate != curr) {
                ListNode temp = iterate.next;
                iterate.next = prev;
                prev = iterate;
                if (steps < k)
                    res = iterate;
                if (counter == k-1 && prevHead != null) {
                    prevHead.next = iterate;
                }
                iterate = temp;
                ++counter;
                ++steps;
            }
            // attach grouphead to next curr
            groupHead.next = curr;
            prevHead = groupHead;
        }
        return res;
    }
}
