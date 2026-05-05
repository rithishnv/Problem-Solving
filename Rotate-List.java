1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode rotateRight(ListNode head, int k) {
13        int n=0;
14        ListNode a=head;
15        while(a!=null){
16            n++;
17            a=a.next;
18        }
19        if(n<=1){
20            return head;
21        }
22        a=head;
23        for(int i=0;i<n-1;i++){
24            a=a.next;
25        }
26        a.next=head;
27        n=n-(k%n);
28        while(n-->0){
29            a=a.next;
30        }
31        head=a.next;
32        a.next=null;
33        return head;
34    }
35}