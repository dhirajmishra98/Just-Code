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
     int dhiraj = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        helper(root,max);
        return dhiraj;
    }
    private void helper(TreeNode root, int max){
        if(root==null) return ;
        
        if(max<=root.val)
            max = root.val;
        
        if(max == root.val){
            dhiraj++;
        }
            
        
        helper(root.left, max);
        helper(root.right, max);
    }
}