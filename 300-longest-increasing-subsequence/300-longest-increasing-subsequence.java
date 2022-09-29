class Solution {
    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
    
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans, lis(i,nums,dp));
        }
        return ans;
    }
    
    private static int lis(int i,int[] nums, int[] dp){
        if(dp[i]!= -1) return dp[i];
        int ans = 1;
        for(int j=0;j<i;j++){
            if(nums[i] > nums[j])
            ans = Math.max(ans, lis(j,nums,dp)+1);
        }
        return dp[i] = ans;
    }
}