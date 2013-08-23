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
    int height = 0;
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            height = 0;
            return true;
        }
        if(!isBalanced(root.left)) return false;
        int hLeft = height;
        if(!isBalanced(root.right)) return false;
        if(Math.abs(hLeft - height) > 1) return false;
        height = Math.max(hLeft + 1, height + 1);
        return true;
    }
}
