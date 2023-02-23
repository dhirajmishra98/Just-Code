//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int mod = (int)1e9+7;
    int uniquePaths(int n, int m, int[][] grid) {
        if(grid[0][0]==0 || grid[n-1][m-1]==0) return 0;
        
        int [][] dp = new int[n][m];
        for(int []rows : dp){
            Arrays.fill(rows,-1);
        }
        
        return helper(0,0,grid,n,m,dp);
    }
    
    private int helper(int i, int j, int[][] grid,int n, int m,int[][] dp){
        if(i>=n || j>=m || grid[i][j]==0) return 0;
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = ((helper(i+1,j,grid,n,m,dp))%mod +(helper(i,j+1,grid,n,m,dp))%mod)%mod;
    }
};