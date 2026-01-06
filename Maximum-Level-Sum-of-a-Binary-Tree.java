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
18        long max=Long.MIN_VALUE;
19        int min=1;
20        Queue<TreeNode> queue=new LinkedList<>();
21        queue.add(root);
22        int l=0;
23        while(!queue.isEmpty()){
24            int s=queue.size();
25            long sum=0;
26            int f=0;
27            l++;
28            for(int i=0;i<s;i++){
29                TreeNode x=queue.poll();
30                if(x==null)
31                continue;
32                f=1;
33                sum+=x.val;
34                queue.add(x.left);
35                queue.add(x.right);
36            }
37            if(sum>max && f==1){
38                max=sum;
39                min=l;
40            }
41        }
42        return min;
43    }
44}