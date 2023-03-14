//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> a) {
        
        int []arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = a.get(i);
        }
        
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