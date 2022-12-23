//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(1);
      for(int x : arr) temp.add(x);
      temp.add(1);
      
      int[] dhiraj = new int[N+2];
      for(int i=0;i<N+2;i++){
          dhiraj[i] = temp.get(i);
      }
      
    //   System.out.println(Arrays.toString(dhiraj));
      int[][] dp = new int[N+1][N+1];
      for(int []rows : dp){
        Arrays.fill(rows,-1);
      }
    
     return memoization(1,N,dhiraj,dp);
    // return 0;
  }
  
  private static int memoization(int i, int j, int[] arr, int[][] dp){
      if(i>j) return 0;
      if(dp[i][j] != -1) return dp[i][j];
      
      int maxi = Integer.MIN_VALUE;
      
      for(int ind = i; ind <= j; ind++){
          
         int cost = (arr[i-1]*arr[ind]*arr[j+1]) + memoization(i,ind-1,arr,dp) + memoization(ind+1,j,arr,dp);
          
          maxi = Math.max(maxi,cost);
      }
      
      return dp[i][j] = maxi ;
  }
}
     