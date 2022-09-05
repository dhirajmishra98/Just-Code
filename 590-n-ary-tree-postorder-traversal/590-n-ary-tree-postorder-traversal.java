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
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(s.size()>0){
            Node curr = s.pop();
            ans.add(curr.val);
            
            for(Node child : curr.children){
                s.push(child);
            }
        }
         Collections.reverse(ans);
        return ans;
    }
}

/*
//recursive
class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null) return ans;
        
        
        for(Node child : root.children){
            postorder(child);
        }
        ans.add(root.val);
        
        return ans;
    }
}
*/