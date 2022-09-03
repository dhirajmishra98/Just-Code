//Approach 2 (XOR)
class Solution {
    public int missingNumber(int[] nums) {
       int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = sum^nums[i];
        }
        
        for(int i=0;i<=nums.length;i++){
            sum = sum^i;
        }
        
        return sum;
    }
}



/*
//Approach 1 
class Solution {
    public int missingNumber(int[] nums) {
       int size = nums.length;
        int totalSum = (size * (size+1))/2;
        
        for(int x : nums){
            totalSum -= x;
        }
        
        return totalSum ;
    }
}
*/