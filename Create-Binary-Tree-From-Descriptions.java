1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 * int val;
5 * TreeNode left;
6 * TreeNode right;
7 * TreeNode() {}
8 * TreeNode(int val) { this.val = val; }
9 * TreeNode(int val, TreeNode left, TreeNode right) {
10 * this.val = val;
11 * this.left = left;
12 * this.right = right;
13 * }
14 * }
15 */
16class Solution {
17    public TreeNode createBinaryTree(int[][] description) {
18        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
19        for (int i = 0; i < description.length; i++) {
20            map.put(description[i][0], new TreeNode(description[i][0]));
21            map.put(description[i][1], new TreeNode(description[i][1]));
22        }
23        int root=0;
24        for(int i=0;i<description.length;i++){
25            int f=0;
26            for(int j=0;j<description.length;j++){
27                if(description[j][1]==description[i][0]){
28                    f=1;
29                    break;
30                }
31            }
32            if(f==0){
33                root=description[i][0];
34                break;
35            }
36        }
37        TreeNode a = null;
38        TreeNode b = map.get(root);
39        for (int[] i : description) {
40            a = map.get(i[0]);
41            if (i[2] == 1)
42                a.left = map.get(i[1]);
43            else
44                a.right = map.get(i[1]);
45        }
46        return b;
47    }
48}