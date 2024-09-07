/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean search(ListNode h,TreeNode r){
        if(h==null)
        return true;
        if(r==null)
        return false;
        if(h.val!=r.val)
        return false;
        return search(h.next,r.right) || search(h.next,r.left);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return search1(head,root);
    }
    public boolean search1(ListNode h,TreeNode r){
        if(r==null)
        return false;
        if(search(h,r))
        return true;
        return search1(h,r.left)||search1(h,r.right);
    }
}