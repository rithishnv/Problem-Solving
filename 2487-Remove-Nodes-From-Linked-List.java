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

    public ListNode removeNodes(ListNode head) {
        ListNode prev=null,curr=head,nex=null;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        head=prev;
        curr=prev;
        int max=Integer.MIN_VALUE;
        while(head!=null){
           if(head.val<max){
            curr.next=head.next;
           }
           else{
            max=head.val;
            curr=head;
           }
           head=head.next;
        }
        curr=prev;
        prev=null;
        nex=null;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
        
    }
}