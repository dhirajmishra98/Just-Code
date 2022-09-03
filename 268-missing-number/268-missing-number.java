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