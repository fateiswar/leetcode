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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p = phead, pre = null, cur = p.next, next = null, end = null;
        for(; p != null; ){
            if(p.next == null || p.next.next == null) break;
            end = p.next.next.next;
            for(pre = null, cur = p.next; cur != end;){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            next = p.next;
            p.next = pre;
            next.next = end;
            p = next;
        }
        return phead.next;
    }
}
