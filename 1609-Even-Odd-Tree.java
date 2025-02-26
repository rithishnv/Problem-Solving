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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean b=true;
        while(!q.isEmpty()){
            int n=q.size();
            int p=-1;
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                if(p==-1){
                if(b==true && t.val%2!=0)
                p=t.val;
                else if(b==false && t.val%2==0)
                p=t.val;
                else
                return false;
                }
                else if(b==true && p<t.val && t.val%2!=0){
                    p=t.val;
                }
                else if(b==false && p>t.val && t.val%2==0){
                    p=t.val;
                }
                else
                return false;
                if(t.left!=null)
                q.add(t.left);
                if(t.right!=null)
                q.add(t.right);
            }
            b=!b;
        }
        return true;
    }
}