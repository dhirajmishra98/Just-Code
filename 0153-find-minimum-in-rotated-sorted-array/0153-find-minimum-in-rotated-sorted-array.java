class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start = 0, end = nums.length-1;
        
        if(nums[end] > nums[0]) return nums[0];
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid-1]>nums[mid]) return nums[mid];
            
            if(nums[mid]>nums[0]) start = mid+1;
            else end = mid-1; 
        }
        return Integer.MAX_VALUE;
        
        /*
        //Brute Force : TC=O(n), SC=O(1)
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < min ) min = nums[i];
        }
        return min;
        */
    }
}