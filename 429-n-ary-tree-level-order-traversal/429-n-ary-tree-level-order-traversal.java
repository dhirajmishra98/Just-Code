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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root == null) return l;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(q.size() > 0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
           for(int i=0;i<size;i++){
               Node curr = q.poll();
               for(Node child : curr.children){
                   q.add(child);
               }
               list.add(curr.val);
           }
            l.add(list);
        }
        return l;
    }
}