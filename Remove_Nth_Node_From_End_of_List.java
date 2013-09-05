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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p = phead, cur = null, pre = null, next = null;
        for(int i = 1; i <= n && p != null; i++) p = p.next;
        if(p == null) return head;
        for(pre = null, cur = phead; p != null; ){
            pre = cur;
            cur = cur.next;
            p = p.next;
        }
        pre.next = cur.next;
        return phead.next;
    }
}
