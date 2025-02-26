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
        Set<ListNode> li=new HashSet<>();
        while(fast!=null && fast.next!=null){
            if(!li.add(slow))
            return slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
}