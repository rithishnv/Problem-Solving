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
17    public int iBalanced(TreeNode root){
18        if(root== null)
19        return 0;
20        int rl=iBalanced(root.left);
21        if(rl==-1){
22            return -1;
23        }
24        int rr=iBalanced(root.right);
25        if(rr==-1){
26            return -1;
27           
28        }
29        if(Math.abs(rl-rr)>1)
30        return -1;
31        return Math.max(rl,rr)+1;
32    }
33    public boolean isBalanced(TreeNode root) {
34        return (iBalanced(root)!=-1)?true:false;
35    }
36}