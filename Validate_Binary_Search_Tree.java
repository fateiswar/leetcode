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
    int[] range;
    public Solution(){
        range = new int[2];
    }
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            range = null;
            return true;
        }
        if(!isValidBST(root.left)) return false;
        int[] left = range;
        if(range != null && range[1] >= root.val) return false;
        if(!isValidBST(root.right)) return false;
        if(range != null && range[0] <= root.val) return false;
        int[] sub = new int[]{root.val, root.val};
        if(left != null) sub[0] = left[0];
        if(range != null) sub[1] = range[1];
        range = sub;
        return true;
    }
}
