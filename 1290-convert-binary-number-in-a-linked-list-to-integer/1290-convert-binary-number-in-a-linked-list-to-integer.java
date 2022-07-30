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
    public int getDecimalValue(ListNode head) {
        String binaryString = "";
        ListNode tempNode = head;
        while(tempNode != null){
            int temp = tempNode.val;
            String s = Integer.toString(temp);
            binaryString = binaryString + s;
            tempNode = tempNode.next;
            
        }
        return Integer.parseInt(binaryString,2);
    }
}