//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        /*
        //memoization : TC=O(N*W), SC=O(N*W)+O(N)
        int[][] dp = new int[N][W+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return memoization(N-1,wt,val,W,dp);
        */
        
        /*
        //Tabulation : TC=O(N*W), SC=O(N*W)
        int[][] dp = new int[N][W+1];
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = (i/wt[0])*val[0];
        }
        for(int ind=1;ind<N;ind++){
            for(int target=0;target<=W;target++){
                int notpick = dp[ind-1][target];
                int pick = 0;
                if(wt[ind] <= target){
                    pick = val[ind] + dp[ind][target-wt[ind]];
                }
                
                dp[ind][target] = Math.max(pick,notpick);
            }
        }
        return dp[N-1][W];
        */
        
        //Optimized Tabulation : TC=O(N*W), SC=O(W)
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        for(int i=wt[0];i<=W;i++){
            prev[i] = (i/wt[0])*val[0];
        }
        for(int ind=1;ind<N;ind++){
            for(int target=0;target<=W;target++){
                int notpick = prev[target];
                int pick = 0;
                if(wt[ind] <= target){
                    pick = val[ind] + curr[target-wt[ind]];
                }
                
                curr[target] = Math.max(pick,notpick);
            }
            prev = curr;
        }
        return prev[W];
    }
    
    private static int memoization(int n, int[] wt, int[] val, int W,int[][] dp ){
        if(n==0){
            return (W/wt[0])*val[0];
        }
        if(dp[n][W] != -1) return dp[n][W];
        
        int notpick = memoization(n-1,wt,val,W,dp);
        int pick = 0;
        if(wt[n] <= W){
            pick =val[n]+memoization(n,wt,val,W-wt[n],dp);
        }
        
        return dp[n][W]= Math.max(pick,notpick);
    }
}