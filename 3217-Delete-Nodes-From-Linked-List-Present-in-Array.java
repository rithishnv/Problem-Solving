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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode h=new ListNode(0);
        ListNode h1=h;
        Set<Integer> li=new HashSet<>();
        for(int i:nums){
            li.add(i);
        }
        while(head!=null){
            if(!li.contains(head.val)){
                h.next=head;
                h=h.next;
            }
            head=head.next;
        }
        h.next=null;
        return h1.next;
    }
}