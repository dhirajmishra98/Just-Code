class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == target) return sum;
                else if(sum<target) start++;
                else end--;
                
                if(Math.abs(sum-target) < diff){
                    diff = Math.abs(sum-target);
                    res = sum;
                }
            }
        }
        return res; 
    }
}