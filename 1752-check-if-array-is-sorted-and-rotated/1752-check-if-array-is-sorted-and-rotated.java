class Solution {
    public boolean check(int[] nums) {
        int check = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1])
                check++;
        }
        
        if(check==0) return true;
        
        if(check==1 && nums[0]>=nums[nums.length-1])
            return true;
        
        return false;
    }
}