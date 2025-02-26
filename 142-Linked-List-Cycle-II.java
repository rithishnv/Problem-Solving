/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        List<ListNode> li=new ArrayList<>();
        while(fast!=null && fast.next!=null){
            if(li.contains(slow))
            return slow;
            li.add(slow);
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
}