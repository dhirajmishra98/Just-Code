//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int currEdges = 0;
    int currNodes = 0;
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        int result = 0;
        boolean []visited = new boolean[V+1];
        
        for(int i=1;i<=V;i++){
            if(!visited[i]){
                currEdges = 0;
                currNodes = 0;
                
                dfs(i,adj,visited);
                currEdges /= 2;
                if(currEdges == (currNodes*(currNodes-1))/2){
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node] = true;
        currNodes ++;
        currEdges += adj.get(node).size();
        
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode])
                dfs(adjNode,adj,visited);
        }
    }
}