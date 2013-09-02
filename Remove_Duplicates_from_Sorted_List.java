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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode p1 = head;
        for(; p1.next != null;){
            if(p1.next.val == p1.val)
                p1.next = p1.next.next;
            else
                p1 = p1.next;
        }
        return head;
    }
}
