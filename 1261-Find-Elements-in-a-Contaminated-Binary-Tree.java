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
class FindElements {
    Set<Integer> li=new HashSet<>();
    void search(TreeNode root,int val){
    if(root==null){
    return;
    }
    li.add(val);
    search(root.left,2*val+1);
    search(root.right,2*val+2);
    return;
    }
    public FindElements(TreeNode root) {
        search(root,0);
    }
    
    public boolean find(int target) {
        return li.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */