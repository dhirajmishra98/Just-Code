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
//     public ListNode deleteMiddle(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode temp = head;

//         if(temp.next == null) return null;
//         if(slow.next.next == null){
//             slow.next = null;
//             return head;
//         }
//         while(fast!=null && fast.next!=null){
//             temp = slow;
//             slow = slow.next;
            
//             if(fast.next.next!=null)
//                 fast = fast.next.next;
//             else 
//                 break;
//         }
        
//         temp.next = slow.next;
//         return head;
//     }
    
     public ListNode deleteMiddle(ListNode head) {
         if(head.next == null) return null;
        ListNode slow = head;
         ListNode fast = head.next.next;
         
         while(fast!=null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
         }
         slow.next = slow.next.next;
         return head;
    }
    
}