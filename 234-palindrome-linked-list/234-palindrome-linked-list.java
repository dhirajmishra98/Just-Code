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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        ListNode currNode = head;
        while(currNode!=null){
            arr.add(currNode.val);
            currNode = currNode.next;
        }
        
        int n = arr.size();
        for(int i=0;i<=n/2;i++){
            if(arr.get(i) != arr.get(n-1-i))
                return false;
        }
        return true;
    }
}