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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        if(root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        if(root.right != null && hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}
