//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
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
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,n-1,dp);
    }
    
    private int helper(int[] arr, int ind,int[] dp){
        if(ind==0) return arr[0];
        if(ind <= 1) return Math.max(arr[1],arr[0]);
        if(dp[ind]!=-1) return dp[ind];
        if(ind<0) return 0;
        
        int pick = arr[ind]+helper(arr,ind-2,dp);
        int notpick = helper(arr,ind-1,dp);
        
        return dp[ind] = Math.max(pick,notpick);
    }
}