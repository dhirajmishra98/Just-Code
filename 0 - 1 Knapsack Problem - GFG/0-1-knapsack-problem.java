//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    class Pair{
        int wt,val;
        Pair(int weight, int value){
            wt = weight;
            val = value;
        }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    { 
        /*
        //Memoization with Pair class - combine wt,val into a array of pair
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(wt[i],val[i]);
        }
        
        int[][] dp = new int[n][W+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return memoizationWithPair(n-1,arr,W,dp);
        */
        
        /*
        //Memoization : TC=O(N*W), SC=O(N*W)+O(N)
        int[][] dp = new int[n][W+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return memoization(n-1,wt,val,W,dp);
        */
        
        /*
        //Tabulation : TC=O(N*W),SC=O(N*W) 
        int[][] dp = new int[n][W+1];
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = val[0];
        }
        
        for(int index = 1;index < n;index++){
            for(int w = 0;w<=W;w++){
                int notpick = dp[index-1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[index] <= w){
                    pick = val[index] + dp[index-1][w-wt[index]];
                }
                
                dp[index][w] = Math.max(notpick,pick);
            }
        }
        return dp[n-1][W];
        */
        
        //Tabulation - Space Optimized : 
        int[] prev = new int[W+1];
        for(int i=wt[0];i<=W;i++){
            prev[i] = val[0];
        }
        
        for(int i=1;i<n;i++){
            int[] curr = new int[W+1];
            for(int j=0;j<=W;j++){
                int notpick = prev[j];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j){
                    pick = val[i] + prev[j-wt[i]];
                }
                
                curr[j] = Math.max(notpick, pick);
            }
            prev = curr;
        }
        return prev[W];
    } 
    
    private int memoization(int n,int[] wt, int[]val, int W,int[][] dp){
        if(n==0){
            if(wt[n] <= W) return val[n];
             else return 0;
        }
        
        if(dp[n][W] != -1) return dp[n][W];
        
        int notpick = memoization(n-1,wt,val,W,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[n] <= W){
            pick = val[n] + memoization(n-1,wt,val,W-wt[n],dp);
        }
        
        return dp[n][W] = Math.max(notpick,pick);
    }
    
    // private int memoizationWithPair(int n, Pair[] arr, int W,int[][] dp){
    //     if(n==0){
    //         if(arr[n].wt <= W) return arr[n].val;
    //          else return 0;
    //     }
        
    //     if(dp[n][W] != -1) return dp[n][W];
        
    //     int notpick = memoization(n-1,arr,W,dp);
    //     int pick = Integer.MIN_VALUE;
    //     if(arr[n].wt <= W){
    //         pick = arr[n].val + memoization(n-1,arr,W-arr[n].wt,dp);
    //     }
        
    //     return dp[n][W] = Math.max(notpick,pick);
    // }
}


