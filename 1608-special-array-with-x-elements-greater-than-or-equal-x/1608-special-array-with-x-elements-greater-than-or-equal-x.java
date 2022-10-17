class Solution {
    public int specialArray(int[] nums) {
        // return bruteForce(nums);
        return binarySearch(nums);
    }
    
    private static int binarySearch(int[] arr){
        int start = 0, end = arr.length;
        while(start <= end){
            int mid = start + (end-start)/2;
            int curr = count(arr,mid);
            
            if(mid == curr) return mid;
            if(curr > mid) start++; //start = mid+1;
            else end--; //end = mid-1;
        }
        return -1;
    }
    
    private static int count(int[] arr, int target){
        int count = 0;
        for(int x : arr){
            if(x>=target) count++;
        }
        return count;
    }
    
    private static int bruteForce(int[] nums){
        int count = 0,i,j;
        for(i=1;i<=nums.length;i++){
            count = 0;
            for(j=0;j<nums.length;j++){
                if(nums[j] >= i) count++;
            }
            if(count == i) return count;
        }
        return -1;
    }
}