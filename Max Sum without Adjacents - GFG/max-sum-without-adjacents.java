//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        //Normal Recursive solution give TLE -> implement DP memoization
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return memoization(arr,n-1,dp);
    }
    
    private int memoization(int[] arr, int size,int[] dp){
        if(size<0) return 0;
        if(dp[size] != -1) return dp[size];
        
        int pick = arr[size]+memoization(arr,size-2,dp);
        int notpick = memoization(arr,size-1,dp);
        
        return dp[size] = Math.max(pick,notpick);
        // return Math.max(arr[size]+memoization(arr,size-2),memoization(arr,size-1));
        
    }
}