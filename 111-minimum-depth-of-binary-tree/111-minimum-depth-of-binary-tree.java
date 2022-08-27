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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
       
        // return 1+Math.min(minDepth(root.left),minDepth(root.right));
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        
        int a = 1+Math.min(lh,rh);
        int b = Math.min(lh,rh);
        
        if( b==0) return 1+Math.max(lh,rh);
        return a;
        
    
    }
}