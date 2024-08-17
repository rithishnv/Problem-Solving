/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode a = new TreeNode(0);
    TreeNode b = a;

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        b.right = new TreeNode(root.val);
        b = b.right;
        inOrder(root.right);
        return;
    }

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return a.right;
    }
}