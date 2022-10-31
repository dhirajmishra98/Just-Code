class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combines(ans, new ArrayList<>(),1,n,k);
        return ans;
    }
    
    private void combines(List<List<Integer>> ans,List<Integer> arr, int start, int n, int k){
        if(k==0){
            ans.add(new ArrayList<Integer>(arr));
            return ;
        }
        
        for(int i=start;i<=n-k+1;i++){
            arr.add(i);
            combines(ans,arr,i+1,n,k-1);
            arr.remove(arr.size()-1);
        }
    }
}