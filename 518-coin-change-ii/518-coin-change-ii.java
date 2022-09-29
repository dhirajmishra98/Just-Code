class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[301][5001];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return memoise(coins.length-1,amount,coins,dp);
    }
    
    private static int memoise(int index, int amount, int[] coins, int[][]dp){
        if(amount == 0) return 1;
        if(index < 0) return 0;
        
        if(dp[index][amount] != -1) return dp[index][amount];
        
        int ways = 0;
        for(int coin_amount = 0; coin_amount <= amount; coin_amount+=coins[index]){
            ways += memoise(index-1,amount-coin_amount,coins,dp);
        }
        
        return dp[index][amount] = ways;
    }
}