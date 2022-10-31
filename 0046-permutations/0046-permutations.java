class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutations(list,nums,0);
        return list;
    }
    
    private void permutations(List<List<Integer>> list, int[] nums, int index){
        if(index == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int x : nums){
                curr.add(x);
            }
            list.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            permutations(list,nums,index+1);
            swap(i,index,nums);
        }
    }
    
    private void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}