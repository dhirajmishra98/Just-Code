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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp =  head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        // System.out.println(count);
        
        ListNode dhiraj = head;
        for(int i=1;i<=count;i++){
            
            if(i == (count/2)+1){
                return dhiraj;
            }
            dhiraj = dhiraj.next;
        }
        return head;
    }
}