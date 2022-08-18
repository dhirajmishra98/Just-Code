class Solution {
    public int findKthPositive(int[] arr, int k) {
        // return approach1(arr,k);
        return approach2(arr,k);
    }
    
    static int approach1(int[] arr, int k){
        for(int x : arr){
            if(x < k)
                k++;
            else 
                break;
        }
        return k;
    }
    
    static int approach2(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if (arr[mid]-(mid+1) < k){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return k+start;
    }
}