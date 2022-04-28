class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int i;
        bool dhiraj = false;
        for(i=1;i<nums.size();i++){
            if(nums[i]==nums[i-1]){
                dhiraj = true;
                break;
            }
        }
      return dhiraj;  
    }
};