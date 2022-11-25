//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    long[][] dp;
    long count(long n)
    {
        dp = new long[64][64];
        for(long []row : dp){
            Arrays.fill(row,-1);
        }
        
        int positions=0,ones=0;
        long ans=0;
        while(n>0){
            if((n&1)==1){
                ones++;
                ans += nCr(positions,ones);
            }
            positions++;
            n=n>>1;
        }
        return ans;
    }
    
    private long nCr(int n,int r){
        if(r>n) return 0;
        if(r==0 || n==r) return 1;
        if(dp[n][r] != -1) return dp[n][r];
        
        return dp[n][r]=nCr(n-1,r-1)+nCr(n-1,r);
    }
}