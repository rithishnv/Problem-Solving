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
    public TreeNode recoverFromPreorder(String traversal) {
        int i=0,c=0;
        StringBuilder sb=new StringBuilder();
        Stack<TreeNode> stack=new Stack<>();
        while(i<traversal.length()){
            while(i<traversal.length() && traversal.charAt(i)=='-'){
            i++;
            c++;
            }
            while(i<traversal.length() && traversal.charAt(i)!='-'){
                sb.append(traversal.charAt(i));
                i++;
            }
            int n=Integer.parseInt(sb.toString());
            TreeNode t=new TreeNode(n);
            while(stack.size()>c){
                stack.pop();
            }
            if(!stack.isEmpty()){
            TreeNode t1=stack.peek();
            if(t1.left==null)
            t1.left=t;
            else
            t1.right=t;
            }
            stack.push(t);
            c=0;
            sb.setLength(0);
            }
            while(stack.size()>1)
            stack.pop();
        return stack.pop();
        }
    }
