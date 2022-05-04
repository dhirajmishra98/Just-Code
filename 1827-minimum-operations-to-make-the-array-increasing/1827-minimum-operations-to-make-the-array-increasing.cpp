class Solution {
public:
    int minOperations(vector<int>& nums) {
        if(nums.size() <= 1)
            return 0; 
        
        int minop = 0;
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]>=nums[i+1]){
                int diff = abs(nums[i+1]-nums[i]);
                nums[i+1] = nums[i+1]+diff+1;
                minop = minop+(diff+1);
            }
        }
        return minop;
    }
};