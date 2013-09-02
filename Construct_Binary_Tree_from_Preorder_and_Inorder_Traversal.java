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
    TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2){
        if(start1 == end1) return null;
        for(int i = start2; i < end2; i++)
            if(preorder[start1] == inorder[i]){
                TreeNode root = new TreeNode(indorder[i]);
                root.left = buildTree(preorder, start1 + 1, i - start2 + start1 + 1,
                                    inorder, start2, i);
                root.right = buildTree(preorder, end1 - end2 + i + 1, end1,
                                    inorder, i + 1, end2);
                return root;
            }
        return null;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder == null || inorder == null) return null;
        if(preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}
