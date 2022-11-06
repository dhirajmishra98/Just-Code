//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        /*
        //memoization : TC=O(N*sum), SC=O(N*sum)+O(N)
        int[][] dp = new int[N][sum+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return memoization(N-1,arr,sum,dp)>0 ? true : false;
        */
        
        boolean[][] dp = new boolean[N][sum+1];
        for(int i=0;i<N;i++) dp[i][0] = true;
        dp[0][arr[0]] = true;
        
        for(int ind=1;ind<N;ind++){
            for(int target=1;target<=sum;target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind]<=target){
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = take|notTake;
            }
        }
        return dp[N-1][sum];
        
    }
    
    private static int memoization(int n, int[] arr, int sum, int[][] dp){
        if(sum==0) return 1;
        if(n<0) return 0;
        if(n==0) return sum==arr[n]?1:0;
        if(dp[n][sum] != -1) return dp[n][sum];
        
        int isCorrect = memoization(n-1,arr,sum,dp);
        if(sum-arr[n] >= 0){
            isCorrect  |= memoization(n-1,arr,sum-arr[n],dp);
        }
        
        return dp[n][sum] = isCorrect;
    }
}