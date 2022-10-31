class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        /*
        //Iterative Approach : TC=O(n*2^n) , SC=O(n*2^n)
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        
        for(int x : nums){
            int size = list.size();
            for(int i=0;i<size;i++){
                List<Integer> curr = new ArrayList<>(list.get(i));
                curr.add(x);
                list.add(curr);
            }
        }
        return list;
        */
        
        List<List<Integer>> list = new ArrayList<>();
        subset(list,new ArrayList<Integer>(),nums,0);
        return list;
    }
    
    private void subset(List<List<Integer>> list,  ArrayList<Integer> curr, int[] nums,int index){
        list.add(new ArrayList<>(curr));
        
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            subset(list,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
}