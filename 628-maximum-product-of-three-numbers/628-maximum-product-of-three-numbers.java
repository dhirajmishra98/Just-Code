class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int s= nums.length-1;
        
        int front = nums[0]*nums[1]*nums[s];
        int end = nums[s]*nums[s-1]*nums[s-2];
        
        return front>end?front:end;
    }
}