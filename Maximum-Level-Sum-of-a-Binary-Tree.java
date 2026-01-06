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
17    public int maxLevelSum(TreeNode root) {
18        int max=Integer.MIN_VALUE;
19        int min=1;
20        Queue<TreeNode> queue=new LinkedList<>();
21        queue.add(root);
22        int l=0;
23        while(!queue.isEmpty()){
24            int s=queue.size();
25            int sum=0;
26            l++;
27            for(int i=0;i<s;i++){
28                TreeNode x=queue.poll();
29                sum+=x.val;
30                if(x.left!=null)
31                queue.add(x.left);
32                if(x.right!=null)
33                queue.add(x.right);
34            }
35            if(sum>max){
36                max=sum;
37                min=l;
38            }
39        }
40        return min;
41    }
42}