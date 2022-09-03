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
    public ListNode mergeNodes(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
        head = head.next;
        do{
            while(head.val!=0){
                sum += head.val;
                head = head.next;
            }
            // System.out.print(sum+" ");
            temp.add(sum);
            // dhiraj.next = new ListNode(sum);
            sum = 0;
            head = head.next;
        }while(head!=null);
        
        for(Integer x : temp){
            System.out.print(x+ " ");
        }
       
        
        ListNode dhiraj = new ListNode(temp.get(0));
         ListNode header = dhiraj;
        for(int i=1;i<temp.size();i++){
            
            dhiraj.next = new ListNode(temp.get(i));
            dhiraj = dhiraj.next;
        }
        return header;
    }
}