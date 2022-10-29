//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        adjlist = makeAdjList(adj,V);
        
        int count = 0;
        int []visited = new int[V+1];
        for(int i=0;i<V;i++){
            if(visited[i] != 1){
                count++;
                visited[i] = 1;
                traversal(visited,i,adjlist);
            }
        }
        return count;
    }
    
    private static void traversal(int[] visited,int vertex,ArrayList<ArrayList<Integer>> adjlist ){
        visited[vertex] = 1;
        for(int x: adjlist.get(vertex)){
            if(visited[x]==0)
            traversal(visited,x,adjlist);
        }
    }
    
    private static ArrayList<ArrayList<Integer>> makeAdjList(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }
        return ans;
    }
};
