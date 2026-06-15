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
12    public ListNode deleteMiddle(ListNode head) {
13        int n=0;
14        ListNode t=head;
15        while(t!=null){
16            t=t.next;
17            n++;
18        }
19        if(n==1)
20        return null;
21        t=head;
22        for(int i=0;i<(n/2)-1;i++){
23            t=t.next;
24        }
25        t.next=t.next.next;
26        return head;
27    }
28}