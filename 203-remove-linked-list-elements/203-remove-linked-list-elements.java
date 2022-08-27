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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        if(head == null)
            return head;
        
        while(curr!=null){
            if(head.val == val){
                head = head.next;
                curr = head;
            } 
            else if(curr.next == null){
                break;
            } 
            else if(curr.next.val == val && curr.next.next == null){
               curr.next = null;
                break;   
            }
            else if(curr.next.val == val){
                 curr.next = curr.next.next;
            } 
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}