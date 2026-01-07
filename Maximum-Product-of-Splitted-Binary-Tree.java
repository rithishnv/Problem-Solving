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
17    public long dfs(TreeNode node){
18        if(node==null)
19        return 0;
20        node.val+=dfs(node.left)+dfs(node.right);
21        return node.val;
22    }
23    public int maxProduct(TreeNode root) {
24        long total=dfs(root);
25        long res=0;
26        Queue<TreeNode> queue=new LinkedList<>();
27        queue.add(root);
28        while(!queue.isEmpty()){
29            TreeNode r=queue.poll();
30            long s=(total-r.val)*r.val;
31            res=Math.max(res,s);
32            if(r.left!=null)
33            queue.add(r.left);
34            if(r.right!=null)
35            queue.add(r.right);
36        }
37        return (int)(res%1000000007);
38    }
39}