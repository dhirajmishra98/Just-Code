class Solution {
    public int singleNonDuplicate(int[] nums) {
        int check = nums[0];
        for(int i=1;i<nums.length;i++){
           check = check^nums[i];
        }
        return check;
    }
}