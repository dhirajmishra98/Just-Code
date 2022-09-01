class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            if(nums[low]%2==0){
                low = low+1;
            } else {
                nums[low]  = nums[low]^nums[high];
                nums[high]  = nums[low]^nums[high];
                nums[low]  = nums[low]^nums[high];
                high--;
            }
        }
        return nums;
    }
}