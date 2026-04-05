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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;
        List<ListNode> arrNodes = new ArrayList<>();
        while(head != null) {
            arrNodes.add(head);
            head = head.next;
        }
        int leftIndex = 0, rightIndex = arrNodes.size()-1;
        while(leftIndex != rightIndex) {
            arrNodes.get(leftIndex).next = arrNodes.get(rightIndex);
            ++leftIndex; 
            if(leftIndex == rightIndex)
                break;
            arrNodes.get(rightIndex).next = arrNodes.get(leftIndex);
            --rightIndex;
        }
        arrNodes.get(leftIndex).next = null;
    }
}
