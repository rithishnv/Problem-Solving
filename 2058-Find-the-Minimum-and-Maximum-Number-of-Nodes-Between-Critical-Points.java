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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         int[] b={-1,-1};
        if(head.next==null||head.next.next==null)
        return b;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        List<Integer> li=new ArrayList<>();
        int i=2;
        while(curr.next.next!=null){
            prev=curr;
            curr=curr.next;
            next=curr.next;
            if(curr.val>prev.val &&curr.val>next.val){
                li.add(i);
            }
            if(curr.val<prev.val &&curr.val<next.val){
                li.add(i);
            }
            i++;
        }
        if(li.size()<=1){
            return b;
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<li.size()-1;j++)
        min=Math.min(min,li.get(j+1)-li.get(j));
        return new int[]{min,li.get(li.size()-1)-li.get(0)};
    }
}