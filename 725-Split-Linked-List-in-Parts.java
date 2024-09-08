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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] a=new ListNode[k];
        int s=0;
        ListNode h=head;
        while(h!=null){
            h=h.next;
            s++;
        }
        h=head;
        int n=s/k;
        int f=s%k;
        ListNode h1=h;
        int i=0;
        while(k-->0){
            ListNode l=h1;
            ListNode l1=l;
            int n1=n;
            if(f-->0){
                n1+=1;
                while(--n1>0&&l!=null){
                    l=l.next;
                }
                 if(l==null){
                    continue;
                }
                h1=l.next;
                l.next=null;
                a[i++]=l1;
            }
            else{
                while(--n1>0&&l!=null){
                    l=l.next;
                }
                if(l==null){
                    continue;
                }
                h1=l.next;
                l.next=null;
                a[i++]=l1;
            }
        }
        return a;
    }
}