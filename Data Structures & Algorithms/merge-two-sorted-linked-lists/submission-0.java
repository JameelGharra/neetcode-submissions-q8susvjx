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
        ListNode ptrList1 = list1, ptrList2 = list2, newList = new ListNode();
        ListNode ptrNewList = newList;
        while(ptrList1 != null && ptrList2 != null) {
            ListNode temp;
            if(ptrList1.val < ptrList2.val) {
                temp = ptrList1;
                ptrList1 = ptrList1.next;
                ptrNewList.next = temp;
            }
            else {
                temp = ptrList2;
                ptrList2 = ptrList2.next;
                ptrNewList.next = temp;
            }
            ptrNewList = temp;
        }
        if (ptrList1 != null) {
           ptrNewList.next = ptrList1; 
        }
        if (ptrList2 != null) {
            ptrNewList.next = ptrList2;
        }
        return newList.next;
    }
}