class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        
        return memoization(nums.length-1, nums, dp);
    }
    
    private int memoization(int index, int[] nums, int[] dp){
        if(index==0) return nums[index];
        if(index == 1) return Math.max(nums[0],nums[1]);
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        
        int pick = nums[index]+memoization(index-2, nums, dp);
        int notpick = 0+memoization(index-1, nums, dp);
        
        return  dp[index] = Math.max(pick, notpick);
    }
}