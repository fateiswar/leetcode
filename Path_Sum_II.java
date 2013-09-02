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
    public void pathSum(TreeNode root, int sum, ArrayList<Integer> path){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val){
                answer.add((ArrayList<Integer>)path.clone());
            }
        }else{
            if(root.left != null)
                pathSum(root.left, sum - root.val, path);
            if(root.right != null)
                pathSum(root.right, sum - root.val, path);
        }
        path.remove(path.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSum(root, sum, path);
        return answer;
    }
}
