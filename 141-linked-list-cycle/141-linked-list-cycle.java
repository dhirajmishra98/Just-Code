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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head ==null)
            return false;
        do{
            if(slow.next==null)
                return false;
            else
            slow = slow.next;
            
            if(fast.next==null || fast.next.next==null)
                return false;
            else
            fast = fast.next.next;
            
            
            if(slow == fast){
                return true;
            }
        }while(fast!=slow);
        return false;
    }
}