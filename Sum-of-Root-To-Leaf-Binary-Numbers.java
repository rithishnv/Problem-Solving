1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    StringBuilder sb=new StringBuilder();
18    public int trav(TreeNode root){
19        int t=0;
20        sb.append(root.val);
21        if(root.left ==null && root.right ==null){
22         t=Integer.parseInt(sb.toString(),2);
23        }
24        if(root.left !=null)
25        t+=trav(root.left);
26        if(root.right!=null)
27        t+=trav(root.right);
28        sb.deleteCharAt(sb.length()-1);
29        return t;
30    }
31    public int sumRootToLeaf(TreeNode root) {
32        return trav(root);
33    }
34}