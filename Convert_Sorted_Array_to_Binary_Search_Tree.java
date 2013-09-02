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
    TreeNode sortedArrayToBST(int[] num, int start, int end){
        if(start >= end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null) return null;
        return sortedArrayToBST(num, 0, num.length);
    }
}
