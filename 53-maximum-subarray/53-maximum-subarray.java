class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int bestMax = nums[0];
        
        for(int i=1;i<nums.length;i++){
            currMax += nums[i];
            if(currMax < nums[i]){
                currMax = nums[i];
            }
            if(bestMax < currMax){
                bestMax = currMax;
            }
        }
        return bestMax;
    }
}