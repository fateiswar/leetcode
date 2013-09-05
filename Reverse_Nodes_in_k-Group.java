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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(k <= 1) return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode pre, cur, next, end, p;
        for(p = phead; p != null; ){
            end = p;
            for(int i = 1; i <= k && end != null; i++)
                end = end.next;
            if(end == null) break;
            end = end.next;
            for(pre = null, cur = p.next; cur != end;){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            p.next.next = end;
            next = p.next;
            p.next = pre;
            p = next;
        }
        return phead.next;
    }
}
