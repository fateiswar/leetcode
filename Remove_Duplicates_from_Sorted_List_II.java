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
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p = phead;
        for(; p.next != null && p.next.next != null;){
            if(p.next.val != p.next.next.val)
                p = p.next;
            else{
                for(int tmp = p.next.val; p.next != null && p.next.val == tmp;)
                    p.next = p.next.next;
            }
        }
        return phead.next;
    }
}
