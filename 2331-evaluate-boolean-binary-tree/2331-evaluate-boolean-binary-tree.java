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
    public boolean evaluateTree(TreeNode root) {
        if(root.left==null && root.right==null){
            if(root.val==1) return true;
            else
                return false;
        }
        if(root.val == 2)
            return helper(root.left)|helper(root.right);
        else 
            return helper(root.left)&helper(root.right);
        
    }
    private boolean helper(TreeNode root){
        switch(root.val){
            case 1:
                return true;
                
            case 0:
                return false;
                
            case 2:
                return helper(root.left)|helper(root.right);
                
            case 3:
                return helper(root.left)&helper(root.right);
        }
        return false;
    }
}