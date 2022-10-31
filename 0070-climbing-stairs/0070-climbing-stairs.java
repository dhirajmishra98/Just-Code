class Solution {
    public int climbStairs(int n) {
        // return count(n);  //TLE
        
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dptable(n,dp);
        
    }
    
    private int dptable (int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n] > 0) return dp[n];
        
        return dp[n] = dptable(n-1,dp)+dptable(n-2,dp);
    }
    
    private int count(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}