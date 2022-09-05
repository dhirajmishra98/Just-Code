/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
         if(root==null) return ans;
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(s.size()>0){
            Node curr = s.pop();
            ans.add(curr.val);
            
            Collections.reverse(curr.children);
            for(Node child : curr.children){
                s.push(child);
            }
        }
        return ans;
    }
    
}