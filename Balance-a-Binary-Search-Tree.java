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
17    List<TreeNode> sortedArr = new ArrayList<>();
18    public TreeNode balanceBST(TreeNode root) {
19        inorderTraverse(root);
20        return sortedArrayToBST(0, sortedArr.size() - 1);
21    }
22    void inorderTraverse(TreeNode root) {
23        if (root == null) return;
24        inorderTraverse(root.left);
25        sortedArr.add(root);
26        inorderTraverse(root.right);
27    }
28    TreeNode sortedArrayToBST(int start, int end) {
29        if (start > end) return null;
30        int mid = (start + end) / 2;
31        TreeNode root = sortedArr.get(mid);
32        root.left = sortedArrayToBST(start, mid - 1);
33        root.right = sortedArrayToBST(mid + 1, end);
34        return root;
35    }
36}