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
    // O(n * k) time - O(1) space
    public ListNode mergeKLists(ListNode[] lists) {
        int notNullCount;
        ListNode dummy = new ListNode(), curr = dummy;
        do {
            notNullCount = 0;
            int minNodeIdx = -1;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    continue;
                }
                notNullCount++;
                if (minNodeIdx == -1 || lists[minNodeIdx].val > lists[i].val) {
                    minNodeIdx = i;
                }
            }
            if (notNullCount == 0)
                break;
            if (lists[minNodeIdx].next == null) {
                notNullCount--;   
            }
            curr.next = lists[minNodeIdx];
            curr = curr.next;
            lists[minNodeIdx] = lists[minNodeIdx].next;
        } while (notNullCount != 0);
        return dummy.next;
    }
}
