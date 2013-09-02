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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        if(m < 1) m = 1;
        if(n < 1) n = 1;
        if(m > n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        if(m == n) return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p1 = phead, pre = phead, next = phead, curr = phead;
        for(int i = 1; i < m && p1 != null; i++) p1 = p1.next;
        if(p1 == null || p1.next == null || p1.next.next == null) return head;
        int i = 0;
        for(pre = null, curr = p1.next, i = m; i <= n && curr != null; i++){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        if(curr == null) p1.next = pre;
        else{
            p1.next.next = curr;
            p1.next = curr;
        }
        return phead.next;
    }
}
