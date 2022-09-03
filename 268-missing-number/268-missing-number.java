
//Approach 3 (Binary Search)
class Solution {
    public int missingNumber(int[] nums) {
       Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int target = 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(target == nums[mid]){
                target++;
                start = 0;
                end = nums.length-1;
            }
            
            if(target > nums[mid]){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
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

/*
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
*/



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