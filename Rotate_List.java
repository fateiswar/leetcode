//uncommitted
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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        if(size == 0 || n % size == 0) return head;
        n %= size;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p1 = phead, p2 = phead;
        for(int i = 1; i <= n; i++) p2 = p2.next;
        for(; p2.next != null; ){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = phead.next;
        phead.next = p1.next;
        p1.next = null;
        return phead.next;
    }
}
