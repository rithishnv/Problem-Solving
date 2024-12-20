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
    public void rev(TreeNode l,TreeNode r,int h){
        if(l==null)
        return;
        if(h%2!=0){
        int d1=l.val;
        l.val=r.val;
        r.val=d1;
        }
        rev(l.left,r.right,h+1);
        rev(r.left,l.right,h+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode d=root;
        rev(d.left,d.right,3);
        return root;
    }
}