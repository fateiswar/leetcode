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
    void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(answer.size() < depth + 1)
            answer.add(new ArrayList<Integer>());
        answer.get(depth).add(root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0);
        for(int i = 1; i < answer.size(); i+=2)
            Collections.reverse(answer.get(i));
        return answer;
    }
}
