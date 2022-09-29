class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[100000];
        Arrays.fill(dp,-1);
        int ans = memoise(coins,amount,dp);
        
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    
    private static int memoise(int[] coins, int amount, int[] dp){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount - coins[i] >= 0)
            ans =(int) Math.min(ans+0L, memoise(coins,amount-coins[i],dp)+1L);
        }
        return dp[amount] = ans;
    }
}