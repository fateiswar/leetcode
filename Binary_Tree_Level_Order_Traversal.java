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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if(root == null) return answer;
        LinkedList<TreeNode> Q1 = new LinkedList<TreeNode>();
        LinkedList<Integer> Q2 = new LinkedList<Integer>();
        Q1.add(root); Q2.add(0);
        while(Q1.size() > 0){
            root = Q1.poll();
            int depth = Q2.poll();
            if (answer.size() < depth + 1) answer.add(new ArrayList<Integer>());
            answer.get(depth).add(root.val);
            if(root.left != null){
                Q1.add(root.left);
                Q2.add(depth + 1);
            }
            if(root.right != null){
                Q1.add(root.right);
                Q2.add(depth + 1);
            }
        }
        return answer;
    }
}
