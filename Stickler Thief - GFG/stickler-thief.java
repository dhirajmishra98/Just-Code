//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        /*
        //Memoization : TC=O(N), SC=O(N)
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return memoization(arr,n-1,dp);
        */
        
        /*
        //Tabulation : TC=O(N), SC=O(N)
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1) pick+=dp[i-2];
            
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
        */
        
        //Tabulation Space Optimized : TC=O(N), SC=O(1)
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1) pick += prev2;
            
            int notpick = prev1;
            int curri= Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
    
    private int memoization(int[] arr, int n, int[] dp){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        
        int pick = arr[n] + memoization(arr,n-2,dp);
        int notpick = memoization(arr,n-1,dp);
        return dp[n] = Math.max(pick,notpick);
    }
}