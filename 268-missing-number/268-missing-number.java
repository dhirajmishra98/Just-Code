class Solution {
    public int missingNumber(int[] nums) {
       int size = nums.length;
        int totalSum = (size * (size+1))/2;
        
        int givenSum = 0;
        for(int x : nums){
            givenSum += x;
        }
        
        return totalSum - givenSum;
    }
}