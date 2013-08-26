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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode phead1 = new ListNode(0), phead2 = new ListNode(0);
        ListNode p1 = phead1, p2 = phead2;
        for(ListNode p = head, next = null; p != null; p = next){
            next = p.next;
            p.next = null;
            if(p.val < x){
                p1.next = p;
                p1 = p;
            }else{
                p2.next = p;
                p2 = p;
            }
        }
        p1.next = phead2.next;
        return phead1.next;
    }
}
