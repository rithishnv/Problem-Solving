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
17	public TreeNode subtreeWithAllDeepest(TreeNode root) {
18		if( root == null ) return null;
19		int left =  depth(root.left);
20		int right = depth(root.right);
21		if( left  == right )
22        return root;
23		if( left > right ) 
24        return subtreeWithAllDeepest(root.left);
25		return subtreeWithAllDeepest(root.right);
26	}
27    public int depth(TreeNode root){
28        if(root == null ) 
29        return 0;
30        return Math.max(depth(root.left),depth(root.right))+1;
31	}
32}