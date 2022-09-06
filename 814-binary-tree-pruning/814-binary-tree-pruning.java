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
    public TreeNode pruneTree(TreeNode root) {
        return containsOnes(root)?root:null;
    }
    
    private boolean containsOnes(TreeNode root){
        if(root==null) return false;
        
        boolean leftContainsOne = containsOnes(root.left);
        boolean rightContainsOne = containsOnes(root.right);
        
        if(!leftContainsOne) root.left = null;
        if(!rightContainsOne) root.right = null;
            
        return root.val==1 || leftContainsOne || rightContainsOne;
    }
}