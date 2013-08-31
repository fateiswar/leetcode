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

class cmp implements Comparator<ListNode>{
    public int compare(ListNode o1, ListNode o2){
        return o1.val == o2.val ? 0 : (o1.val < o2.val ? -1 : 1);
    }
}
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode phead = new ListNode(0);
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new cmp());
        for(ListNode head : lists) if(head != null)
            pq.add(head);
        ListNode curr = phead;
        while(pq.size() > 0){
            ListNode head = pq.poll();
            curr.next = head;
            curr = head;
            if(head.next != null)
                pq.add(head.next);
        }
        return phead.next;
    }
}
