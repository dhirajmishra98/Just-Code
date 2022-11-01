class Solution {
    public void sortColors(int[] nums) {
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