/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    void connect(TreeLinkNode root, int depth, ArrayList<TreeLinkNode> list){
        if(root == null) return;
        if(list.size() < depth + 1) list.add(null);
        if(list.get(depth) != null)
            list.get(depth).next = root;
        list.set(depth, root);
        connect(root.left, depth + 1, list);
        connect(root.right, depth + 1, list);
    }
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        connect(root, 0, list);
    }
}
