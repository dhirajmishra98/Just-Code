class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
        int i=0,j=arr.length-1;
        while(j-i >= k){
            if( Math.abs(arr[i]-x) > Math.abs(arr[j]-x) ){
                i++;
            }
            
            else {
               j--;
            } 
        }
        for(int m=i;m<=j;m++){
            ans.add(arr[m]);
        }
        return ans;
    }
}