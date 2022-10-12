class Solution {
    //O(nlogn)
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>1;i--){
            int a = nums[i], b = nums[i-1], c = nums[i-2];
            // if((a+b)>c && (b+c)>a && (a+c)>b) return a+b+c;
            if(a<(b+c)) return a+b+c;
        }
        return 0;
    }
}