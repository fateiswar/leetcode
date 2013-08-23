/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode ListToBST(ListNode head, ListNode end){
        if(head == end) return null;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode mid = phead, last = phead;
        for(; last.next != end; ){
            mid = mid.next;
            last = last.next;
            if(last.next != end)
                last = last.next;
        }
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = ListToBST(head, mid);
        TreeNode right = ListToBST(mid.next, end);
        root.left = left;
        root.right = right;
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return ListToBST(head, null);
    }
}
