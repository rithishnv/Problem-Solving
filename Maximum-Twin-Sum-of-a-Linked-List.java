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
12    public int pairSum(ListNode head) {
13        ListNode t=head;
14        int n=0;
15        while(t!=null){
16            t=t.next;
17            n++;
18        }
19        int[] a=new int[n];
20        for(int i=0;i<n;i++){
21            a[i]=head.val;
22            head=head.next;
23        }
24        int i=0,j=n-1,max=0;
25        while(i<j){
26            max=Math.max(max,(a[i++]+a[j--]));
27        }
28        return max;
29    }
30}