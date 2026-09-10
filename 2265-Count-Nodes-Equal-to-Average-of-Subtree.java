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
    public int averageOfSubtree(TreeNode root) {
        int cnt=0;
        if(root==null)
        return 0;
        if(root.val==avg(root)/cn(root)){
            cnt++;
        }
        cnt+=averageOfSubtree(root.left);
        cnt+=averageOfSubtree(root.right);
        return cnt;
    }
    public int avg(TreeNode root){
        if(root==null)
        return 0;
        int sum=root.val;
        sum+=avg(root.left);
        sum+=avg(root.right);
        return sum;
    }
    public int cn(TreeNode root){
        if(root==null)
        return 0;
        return 1+cn(root.left)+cn(root.right);
    }
}