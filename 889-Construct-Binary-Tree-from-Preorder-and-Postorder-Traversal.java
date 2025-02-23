/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preind=0,posind=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root=new TreeNode(preorder[preind++]);
        if(root.val!=postorder[posind])
        root.left=constructFromPrePost(preorder,postorder);
        if(root.val!=postorder[posind])
        root.right=constructFromPrePost(preorder,postorder);
        posind++;
        return root;
    }
}