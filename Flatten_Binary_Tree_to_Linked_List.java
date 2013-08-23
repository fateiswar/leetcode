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
    TreeNode walkEnd(TreeNode root){
        while(root.right != null)
            root = root.right;
        return root;
    }
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
        TreeNode right = root.right;
        if(root.left != null){
            flatten(root.left);
            TreeNode end = walkEnd(root.left);
            end.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(right);
    }
}
