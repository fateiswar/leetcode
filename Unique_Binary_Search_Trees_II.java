/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> answer = new ArrayList<TreeNode>();
        if(start == end){
            answer.add(null);
            return answer;
        }
        if(start + 1 == end){
            answer.add(new TreeNode(start));
            return answer;
        }
        for(int i = start; i < end; i++){
            ArrayList<TreeNode> lefts = generateTrees(start, i);
            ArrayList<TreeNode> rights = generateTrees(i + 1, end);
            for(TreeNode left : lefts)
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    answer.add(root);
                }
        }
        return answer;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n + 1);
    }
}
