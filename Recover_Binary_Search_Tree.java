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
    TreeNode a, b, anext;
    TreeNode dfs(TreeNode root, TreeNode pre){
        if(root.left != null){
            TreeNode last = dfs(root.left, pre);
            if(last.val > root.val){
                if(a == null)
                    a = last;
                b = root;
            }
        }else if(pre != null && pre.val > root.val){
            if(a == null)
                a = pre;
            b = root;
        }
        if(root.right != null){
            return dfs(root.right, root);
        }
        return root;
    }
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        a = b = null;
        dfs(root, null);
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
