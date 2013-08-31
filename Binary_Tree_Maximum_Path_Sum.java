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
    int[] maxPathSum2(TreeNode root){
        int[] answer = new int[2];
        if(root.left == null && root.right == null){
            answer[0] = answer[1] = root.val;
            return answer;
        }
        if(root.left == null)
        {
            answer = maxPathSum2(root.right);
            answer[1] = Math.max(answer[1] + root.val, root.val);
            answer[0] = Math.max(answer[0], answer[1]);
            return answer;
        }
        if(root.right == null)
        {
            answer = maxPathSum2(root.left);
            answer[1] = Math.max(answer[1] + root.val, root.val);
            answer[0] = Math.max(answer[0], answer[1]);
            return answer;
        }
        int[] left = maxPathSum2(root.left);
        int[] right = maxPathSum2(root.right);
        answer[1] = root.val;
        if(Math.max(left[1], right[1]) > 0) answer[1] += Math.max(left[1], right[1]);
        answer[0] = Math.max(left[0], right[0]);
        int tmp = root.val;
        if(left[1] > 0) tmp += left[1];
        if(right[1] > 0) tmp += right[1];
        answer[0] = Math.max(answer[0], tmp);
        return answer;
    }
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return maxPathSum2(root)[0];
    }
}
