/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> arr = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null) return arr;
        s.push(root);
        
        while(s.size()>0){
            TreeNode curr = s.pop();
            arr.addFirst(curr.val);
            if(curr.left!=null) s.push(curr.left);
            if(curr.right!=null) s.push(curr.right);
        }
        return arr;
    }
}