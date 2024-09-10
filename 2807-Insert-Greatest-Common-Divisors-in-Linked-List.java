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
    public int  gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null)
        return head;
        ListNode a=head;
        while(a!=null &&a.next!=null){
            int v=gcd(a.val,a.next.val);
            ListNode k=new ListNode(v);
            k.next=a.next;
            a.next=k;
            a=k.next;
        }
        return head;
    }
}