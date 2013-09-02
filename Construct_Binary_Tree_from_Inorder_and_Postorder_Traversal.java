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
    TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
        if(start1 == end1) return null;
        for(int i = start1; i < end1; i++)
            if(inorder[i] == postorder[end2 - 1]){
                TreeNode root = new TreeNode(inorder[i]);
                root.left = buildTree(inorder, start1, i, postorder, start2, i - start1 + start2);
                root.right = buildTree(inorder, i + 1, end1, postorder, i - start1 + start2, end2 - 1);
                return root;
            }
        return null;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder == null || postorder == null) return null;
        if(inorder.length != postorder.length) return null;
        return buildTree(inorder, 0, inorder.length, postorder, 0, inorder.length);
    }
}
