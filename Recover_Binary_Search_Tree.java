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
    TreeNode a, b;
    public TreeNode dfs(TreeNode root, TreeNode pre){
        if(root.left != null){
            pre = dfs(root.left, pre); 
        }
        if(pre != null && pre.val > root.val){
            b = root;
            if(a == null) a = pre;
        }
        if(root.right != null) return dfs(root.right, root);
        return root;
    }
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        a=b=null;
        if(root == null) return;
        dfs(root, null);
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
