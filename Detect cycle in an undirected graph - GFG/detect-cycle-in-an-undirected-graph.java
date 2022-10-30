//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       
        int []visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
            //   if(bfs(visited,i,adj)) return true;
                if(dfs(visited,i,adj,-1)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int[] visited, int currNode,ArrayList<ArrayList<Integer>> adj,int parent){
        visited[currNode] = 1;
        for(Integer x : adj.get(currNode)){
            if(visited[x]==0){
                if(dfs(visited,x,adj,currNode)) return true;
            }
            else if(x != parent) return true;
        }
        return false;
    }
    
    private boolean bfs(int[] visited, int currNode,ArrayList<ArrayList<Integer>> adj ){
        Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(currNode, -1));
       visited[currNode] = 1;
       
        while(q.size()>0){
            int x = q.peek().node;
            int p = q.peek().parent;
            q.remove();
            for(Integer e : adj.get(x)){
                if(visited[e]==0){
                    visited[e] = 1;
                    q.add(new Pair(e,x));
                }else if(p != e) return true;
            }
        }
        return false;
    }
}