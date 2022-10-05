class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }

        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                if(s.contains(nums[i] + diff)){
                    if(s.contains(nums[i] + diff+diff)){
                        result++;
                    }
                }
            }  
        }
        return result;
    }
}