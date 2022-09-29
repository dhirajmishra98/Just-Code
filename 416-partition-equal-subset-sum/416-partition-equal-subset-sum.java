class Solution {
    static int[][] dp = new int[201][20001];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        
        if(sum%2 != 0) return false;
        sum /= 2;
        
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        
        if(memoise(nums.length-1,sum,nums) > 0)
            return true;
        return false;
    }
    
    private static int memoise(int index, int sum, int[] nums){
        if(sum == 0) return 1;
        if(index < 0) return 0;
        if(dp[index][sum] != -1) return dp[index][sum];
        int isPossible = memoise(index-1,sum,nums);
        if(sum-nums[index] >= 0)
        isPossible |= memoise(index-1,sum-nums[index],nums);
        
        return dp[index][sum] = isPossible;
    }
}