class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        for(int j=0;j<nums.size();j++){
        for(int i=0;i<nums.size();i++){
            if(nums[i]==original)
                original = original * 2;
        }
        }
        return original;
    }
};