class Solution {
    public int[] searchRange(int[] nums, int target) {
        return solve(nums,target);
    }
    
    static int[] solve(int[] nums, int target){
        int []ans = {-1,-1};

        ans[0] = findingIndex(nums, target, true);
        if(ans[0] != -1)
        ans[1] = findingIndex(nums, target, false);

        return ans;
    }

    static int findingIndex(int []nums, int target, boolean findingFirst){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start <= end){
            int mid = start+(end-start)/2;

            if(target < nums[mid]){
                end = mid-1;
            } else if(target > nums[mid]){
                start = mid+1;
            } else {
                ans = mid;
                if(findingFirst){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }   
        }
        return ans;
    }
}