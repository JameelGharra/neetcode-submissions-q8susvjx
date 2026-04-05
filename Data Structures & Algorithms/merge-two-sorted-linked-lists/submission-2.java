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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = list1, current2 = list2;
        ListNode dummy = new ListNode(), curr = dummy;
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                curr.next = current1;
                current1 = current1.next;
            }
            else {
                curr.next = current2;
                current2 = current2.next;
            }
            curr = curr.next;
        }
        ListNode rest = (current1 != null) ? current1 : current2;
        if (rest != null) {
            curr.next = rest;
        }
        return dummy.next;
    }
}