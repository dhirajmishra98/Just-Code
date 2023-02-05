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

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution{
    class Pair{
        int wt,node;
        Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
    class Edge implements Comparable<Edge>{
        int wt,u,v;
        Edge(int u, int v, int wt){
            this.wt = wt;
            this.u = u;
            this.v = v;
        }
        
        public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
        }
    }
    
	int spanningTree(int V, int E, int edges[][]){
	    /*
	    //prims Algorithm : TC=O(ElogE), SC=O(E)
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
	        visited[node] = 1; //mark visited while adding to cost
	        sum += wt;
	        
	        for(Pair x : adjList.get(node)){
	            int adjNode = x.node;
	            int adjWt = x.wt;
	            
	            if(visited[adjNode] == 0){ //dont mark visited here
	                pq.add(new Pair(adjWt,adjNode));
	            }
	        }
	    }
	    
	    return sum;
	    */
	    
	    //Krushkal's Algorithm : TC=
	   ArrayList<Edge> adjList = getList(V,E,edges);
	   Collections.sort(adjList);
	   int result = 0;
	   DisjointSet ds = new DisjointSet(V);
	   for(int i=0;i<E;i++){
	       int u = adjList.get(i).u;
	       int v = adjList.get(i).v;
	       int wt = adjList.get(i).wt;
	       
	       if(ds.findUPar(u) != ds.findUPar(v)){
	           result += wt;
	           ds.unionBySize(u, v);
	       }
	   }
	   
	    return result;
	}
	
	private ArrayList<Edge> getList(int V, int E, int[][]edges){
	    ArrayList<Edge> adjList = new ArrayList<>();
	    
	    for(int i=0;i<E;i++){
	        adjList.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    
	    return adjList;
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