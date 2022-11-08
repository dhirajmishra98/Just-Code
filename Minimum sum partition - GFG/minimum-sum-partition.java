//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
        int target = 0;
        for(int x : nums) target += x;

        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean not_taken = dp[i-1][j];
                boolean taken = false;
                if(nums[i] <= j)
                taken = dp[i-1][j-nums[i]];

                dp[i][j] = not_taken||taken;
            }
        }

        int ans = Integer.MAX_VALUE;
            for(int j=0;j<=target/2;j++){
                if(dp[n-1][j] == true){
                    int set1 = j;
                    int set2 = target-j;
                    ans = Math.min(ans,Math.abs(set1-set2));
                }
            }  
        
        return ans;
	} 
}
