/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode phead = new ListNode(0);
        ListNode curr = phead;
        int carry = 0;
        for(ListNode p1 = l1, p2 = l2; carry > 0 || p1 != null || p2 != null; ){
            if(p1 != null) { carry += p1.val; p1 = p1.next; }
            if(p2 != null) { carry += p2.val; p2 = p2.next; }
            curr.next = new ListNode(carry % 10);
            curr = curr.next;
            carry /= 10;
        }
        return phead.next;
    }
}
