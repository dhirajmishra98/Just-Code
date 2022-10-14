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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        if(temp.next == null) return null;
        if(slow.next.next == null){
            slow.next = null;
            return head;
        }
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow = slow.next;
            
            if(fast.next.next!=null)
                fast = fast.next.next;
            else 
                break;
        }
        
        temp.next = slow.next;
        return head;
    }
    
}