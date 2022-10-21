class Solution {
    public void rotate(int[] nums, int k) {
        
         k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
        /*
        //Bruteforce : TC=O(N*K), SC=O(1) -> TLE
        while(k-- >0){
            int temp = nums[nums.length-1];
            for(int i=nums.length-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0] = temp;
        }
       */
    }
    
    private void reverse(int[]nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
 
}