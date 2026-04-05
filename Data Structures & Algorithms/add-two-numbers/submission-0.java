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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1 0 2 3
        //     9 9
        boolean carry = false;
        ListNode curr1 = l1, curr2 = l2;
        ListNode dummy = new ListNode(), res = dummy;
        while (curr1 != null && curr2 != null) {
            ListNode newDigit = new ListNode();
            int newVal = curr1.val + curr2.val;
            if (carry) {
                newVal += 1;
            }
            carry = newVal > 9;
            newDigit.val = newVal % 10;
            res.next = newDigit;
            res = newDigit;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        ListNode rest = curr1 != null ? curr1 : curr2;
        while (carry || rest != null) {
            int newVal = 0;
            if (rest != null) {
                newVal = rest.val;
                rest = rest.next;
            }
            if (carry) {
                newVal += 1;
            }
            carry = newVal > 9;
            ListNode newDigit = new ListNode(newVal % 10);
            res.next = newDigit;
            res = newDigit;
        }
        return dummy.next;
    }
}
