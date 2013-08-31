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
    void dfs(TreeNode root, ArrayList<Integer> answer){
        if(root == null) return;
        dfs(root.left, answer);
        answer.add(root.val);
        dfs(root.right, answer);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> answer = new ArrayList<Integer>();
        dfs(root, answer);
        return answer;
    }
}
