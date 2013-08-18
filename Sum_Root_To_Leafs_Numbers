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
    int answer;
    void dfs(TreeNode root, int k){
        k = k * 10 + root.val;
        if(root.left == null && root.right == null){
            answer += k;
            return;
        }
        if(root.left != null) dfs(root.left, k);
        if(root.right != null) dfs(root.right, k);
    }
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        answer = 0;
        dfs(root, 0);
        return answer;
    }
}
