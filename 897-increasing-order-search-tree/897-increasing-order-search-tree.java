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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummynode = new TreeNode(0);
        TreeNode curr = dummynode;
       
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp!=null || s.size()>0){
            while(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
            
            temp = s.pop();
            curr.right = new TreeNode(temp.val);
            curr = curr.right;

            temp = temp.right;
        }
        
        return dummynode.right;
    }
    
}

/*
//Approach 2 - using no extra space, recursive
class Solution {
    static TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummynode = new TreeNode(0);
        curr = dummynode;
        inorder(root);
        
        return dummynode.right;
    }
    
    static void inorder(TreeNode root){
        if(root == null) 
            return ;
        
        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = curr.right;
        inorder(root.right);
    }
}
*/

/*
//Approach 1 - using extra space, recursive
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        TreeNode dhiraj = new TreeNode(0);
        TreeNode curr = dhiraj; //curr is pointing to dhiraj
        for(int x: ans){
            curr.right = new TreeNode(x);
            curr = curr.right;
        }
        return dhiraj.right;
    }
    
    static void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) 
            return ;
        
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
*/
