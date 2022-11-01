class Solution {
    public void sortColors(int[] nums) {
        // counting(nums);  //Approach 1 : TC=O(N), SC=O(1)
        
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }
        }
    }
    
    private void swap(int i, int j, int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void counting(int[] nums){
        //Approach 1
        int zero=0,one=0,two=0;
        for(int x : nums){
            if(x==0) zero++;
            else if(x==1) one++;
            else two++;
        }
        
        for(int i=0;i<nums.length;i++){
            if(zero>0){
                nums[i] = 0;
                zero--;
            } else if(one>0){
                nums[i] = 1;
                one--;
            } else if(two>0){
                nums[i] = 2;
                two--;
            }
        }
    }
}