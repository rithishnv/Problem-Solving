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
    public int[] nextLargerNodes(ListNode head) {
        ListNode t=head;
        int n=0;
        while(t!=null){
            n++;
            t=t.next;
        }
        int[] arr=new int[n];
        int[] r=new int[n];
        t=head;
        int i=0;
        while(t!=null){
            arr[i++]=t.val;
            t=t.next;
        }
        Stack<Integer> stack =new Stack<>();
        n--;
        while(n>=0){
            if(stack.isEmpty()||stack.peek()>arr[n]){
                r[n]=(stack.isEmpty())?0:stack.peek();
                stack.push(arr[n]);
                n--;
            }
            else
            stack.pop();
        }
        return r;
    }
}