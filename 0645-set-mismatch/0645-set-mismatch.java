class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0,dup=0;
        for(int x: nums) sum += x;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                dup = nums[i];
                break;
            }   
        }
        int org =(( n*(n+1))/2 );
        
        return new int[]{dup,org-sum+dup};
    }
}