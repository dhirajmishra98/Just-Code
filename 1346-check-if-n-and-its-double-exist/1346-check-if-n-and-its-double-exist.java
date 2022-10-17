class Solution {
    public boolean checkIfExist(int[] arr) {
        // return binarySearchApproach(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(2*arr[i])){
                if(map.get(2*arr[i]) != i) return true;
            }
        }
        return false;
    }
    
    private boolean binarySearchApproach(int []arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            boolean check =  binarySearch(arr,2*arr[i],i);
            if(check) return true;
        }
        return false;
    }
    
    private boolean binarySearch(int[] arr, int target, int index){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target && mid!=index) return true;
            else if(arr[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
}