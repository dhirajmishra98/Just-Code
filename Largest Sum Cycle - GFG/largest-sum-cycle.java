//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int ans = -1;
    public long largesSumCycle(int N, int Edge[]){
        boolean []visited = new boolean[N];
        int []pathVisited = new int[N];
       
        for(int i=0;i<N;i++){
            if(!visited[i]){
                dfs(i,Edge,visited,pathVisited);
            }
        }
        
        return ans;
    }
    
    private void dfs(int node,int[] edge,boolean[] visited,int[] pathVisited){
       visited[node] = true;
       pathVisited[node] = 1;
       
       if(edge[node] != -1){
           int adj = edge[node];
           if(!visited[adj]){
               dfs(adj,edge,visited,pathVisited);
           } else if(pathVisited[adj]==1){
               int curr = adj;
               int sum = 0;
               do{
                   sum += curr;
                   curr = edge[curr];
               }while(curr!=adj);
               ans = Math.max(ans,sum);
           }
       }
       pathVisited[node] = 0;
    }
}