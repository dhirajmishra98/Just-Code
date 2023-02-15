//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int water_flow(int [][] mat, int n, int m) {
		boolean [][]indianOcean = new boolean[n][m];
		boolean [][]arabianSea = new boolean[n][m];
		
		//for indianOcean we can enter from 0th row and 0th col
		for(int i=0;i<n;i++){ //for N row from indian ocean
		    dfs(mat,i,0,n,m,indianOcean);
		}
		
		for(int i=0;i<m;i++){ //for M col from indian ocean
		    dfs(mat,0,i,n,m,indianOcean);
		}
		
		//for arabianOcean we can enter from n-1 row and m-1 col
		for(int i=0;i<m;i++){ //moving from down row for M cols
		    dfs(mat,n-1,i,n,m,arabianSea);
		}
		
		for(int i=0;i<n;i++){ //moving from right side for n rows
		    dfs(mat,i,m-1,n,m,arabianSea);
		}
		
		//check how many island can reach both ocean
		int validIslands = 0;
		for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        if(indianOcean[i][j] && arabianSea[i][j])
		            validIslands++;
		    }
		}
		
		return validIslands;
	}
	
	private void dfs(int[][] mat, int i, int j, int n, int m, boolean[][] visited){
	    if(i<0 || i>=n || j<0 || j>=m || visited[i][j]) return;
	    visited[i][j] = true;
	    
	    if(i-1>=0 && !visited[i-1][j] && mat[i-1][j]>=mat[i][j]){ //moving up
	        dfs(mat,i-1,j,n,m,visited);
	    }
	    
	    if(i+1<n && !visited[i+1][j] && mat[i+1][j]>=mat[i][j]){ //moving down
	        dfs(mat,i+1,j,n,m,visited);
	    }
	    
	    if(j-1>=0 && !visited[i][j-1] && mat[i][j-1]>=mat[i][j]){ //moving left
	        dfs(mat,i,j-1,n,m,visited);
	    }
	    
	    if(j+1<m && !visited[i][j+1] && mat[i][j+1]>=mat[i][j]){ //moving right
	        dfs(mat,i,j+1,n,m,visited);
	    }
	}
}