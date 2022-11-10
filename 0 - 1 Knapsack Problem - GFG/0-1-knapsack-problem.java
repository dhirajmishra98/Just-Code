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
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(wt[i],val[i]);
        }
        
        int[][] dp = new int[n][W+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return memoization(n-1,arr,W,dp);
    } 
    
    private int memoization(int n, Pair[] arr, int W,int[][] dp){
        if(n==0){
            if(arr[n].wt <= W) return arr[n].val;
             else return 0;
        }
        
        if(dp[n][W] != -1) return dp[n][W];
        
        int notpick = memoization(n-1,arr,W,dp);
        int pick = Integer.MIN_VALUE;
        if(arr[n].wt <= W){
            pick = arr[n].val + memoization(n-1,arr,W-arr[n].wt,dp);
        }
        
        return dp[n][W] = Math.max(notpick,pick);
    }
}


