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
    ArrayList<ArrayList<Integer>> answer;
    void levelOrderBottom(TreeNode root, int depth){
        if(root == null) return;
        if(answer.size() < depth + 1) answer.add(new ArrayList<Integer>());
        answer.get(depth).add(root.val);
        levelOrderBottom(root.left, depth + 1);
        levelOrderBottom(root.right, depth + 1);
    }
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        levelOrderBottom(root, 0);
        Collections.reverse(answer);
        return answer;
    }
}
