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
class Solution {
    public int pairSum(ListNode head) {
        ListNode t=head;
        int n=0;
        while(t!=null){
            t=t.next;
            n++;
        }
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=head.val;
            head=head.next;
        }
        int i=0,j=n-1,max=0;
        while(i<j){
            max=Math.max(max,(a[i++]+a[j--]));
        }
        return max;
    }
}