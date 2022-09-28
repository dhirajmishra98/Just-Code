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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        if(slow.next == null){
            if(n==1) return null;
            if(n==0) return head;
        }
        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast==null){
                head = slow.next;
            return head;
        }
        while(true){
            
            if(fast.next == null){
                slow.next = slow.next.next;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
}