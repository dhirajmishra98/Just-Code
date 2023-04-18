//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int co=Integer.MAX_VALUE;
    public static int minSubtreeSumBST(int tar, Node root) {
        // code here
        co=Integer.MAX_VALUE;
        // array for returning count and sum.
       int[] c=sol(tar,root);
        return co==Integer.MAX_VALUE ? -1 : co;
    }


    static int[] sol(int t,Node root){


                      //index0-count   1-index-sum     

               if(root==null) return new int[]{0,0};
        //left  number of nodes and number of nodes.
        int[] lsum=sol(t,root.left);


        if(lsum[1]==t){
            if(isBST(root.left,Integer.MIN_VALUE,Integer.MAX_VALUE))
            co=Math.min(lsum[0],co);
        }
         int[] rsum=sol(t,root.right);
           if(rsum[1]==t){
            if(isBST(root.right,Integer.MIN_VALUE,Integer.MAX_VALUE))
            co=Math.min(rsum[0],co);
        }
       
        if((rsum[1]+lsum[1]+root.data)==t){
             if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
             co=Math.min(rsum[0]+lsum[0]+1,co);
        }
        // System.out.println(lsum[1]+" "+rsum[1]+" "+(rsum[1]+lsum[1]+root.data));
        return new int[]{rsum[0]+lsum[0]+1,(rsum[1]+lsum[1]+root.data)};
    }


     static boolean isBST(Node root,int le,int ri){
       if(root==null) return true;


       //checking if right and left are in the specified range.


       if(root.data<=le || root.data>=ri) return false;
       return isBST(root.left,le,root.data) && isBST(root.right,root.data,ri);
    }
}
