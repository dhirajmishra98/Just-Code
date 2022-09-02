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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> arr = new ArrayList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            double qsize = q.size();
            double sum = 0;
            for(int i=0;i<qsize;i++){
                TreeNode curr = q.poll();
                sum  = sum + curr.val;
                
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            
            arr.add(sum/qsize);
        }
        return arr;
    }
}