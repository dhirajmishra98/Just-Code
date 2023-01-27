//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int destination, distance;
    Pair(int destination, int distance){
        this.destination = destination;
        this.distance = distance;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        int []dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int []parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
        
        ArrayList<ArrayList<Pair>> adjList = getAdjList(n,m,edges);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        q.add(new Pair(1,0));
        dist[1] = 0;
        
        while(!q.isEmpty()){
            // int size = q.size();
            // for(int i=0;i<size;i++){
                int nodes = q.peek().destination;
                int d = q.peek().distance;
                q.remove();
                
                for(Pair x : adjList.get(nodes)){
                    int adjNode = x.destination;
                    int adjDist = x.distance;
                    if(dist[adjNode] > d+adjDist){
                        parent[adjNode] = nodes;
                        dist[adjNode] = adjDist+d;
                        q.add(new Pair(adjNode,dist[adjNode]));
                    }
                }
            // }
        }
        
        
        List<Integer> result = new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            result.add(-1);
            return result;
        }
        
        int node = n;
        while(parent[node] != node){
            result.add(node);
            node = parent[node];
        }
        result.add(node);
        Collections.reverse(result);
        
        return result;
    }
    
    private static ArrayList<ArrayList<Pair>> getAdjList(int n, int m, int[][] edges){
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<m;i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        return adjList;
    }
}