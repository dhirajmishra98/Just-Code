class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
    }
}