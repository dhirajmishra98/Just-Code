class Solution {
    public int climbStairs(int n) {
        // return tabulation(new int[n+1],n);
        return memoization(new int[n+1],n);
    }
    
    private static int tabulation(int[] dp, int n){
        //Bottom to Top Approach
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            } else if(i==2){
                dp[i] = dp[i-1]+dp[i-2];
            } else {
            dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    
    private static int memoization(int[] dp, int n){
        //Top to Bottom Approach
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n] > 0 ){
            return dp[n];
        } 
        else{
        int left = memoization(dp,n-1);
        int right = memoization(dp,n-2);
        dp[n] = left+right;
        }
        return dp[n];
    }
}