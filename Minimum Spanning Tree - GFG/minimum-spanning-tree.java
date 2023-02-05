//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    class Pair{
        int wt,node;
        Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
	int spanningTree(int V, int E, int edges[][]){
	    //prims Algorit
	    ArrayList<ArrayList<Pair>> adjList = getAdjList(V,E,edges);
	    int sum = 0;
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.wt-y.wt);
	    pq.add(new Pair(0,0));
	    
	    int[] visited = new int[V];
	    while(!pq.isEmpty()){
	        int node = pq.peek().node;
	        int wt = pq.peek().wt;
	        pq.remove();
	        
	        if(visited[node] == 1) continue;
	        visited[node] = 1;
	        sum += wt;
	        
	        for(Pair x : adjList.get(node)){
	            int adjNode = x.node;
	            int adjWt = x.wt;
	            
	            if(visited[adjNode] == 0){
	                pq.add(new Pair(adjWt,adjNode));
	            }
	        }
	    }
	    
	    return sum;
	}
	
	private ArrayList<ArrayList<Pair>> getAdjList(int V, int E, int[][]edges){
	    ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adjList.add(new ArrayList<Pair>());
	    }
	    
	    for(int i=0;i<E;i++){
	        adjList.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
	        adjList.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
	    }
	    
	    return adjList;
	}
}