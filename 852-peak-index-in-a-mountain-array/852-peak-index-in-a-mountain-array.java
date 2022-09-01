class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return high;
    }
}

/*
//Approach 1 - BruteForce o(n)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
                return i;
        }
        return 1;
    }
}
*/