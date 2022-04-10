class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
       int ans=-1;
        for(int i=0;i<nums.size();i++){
            if(nums[i]!=val){
                ans++;
                nums[ans]=nums[i];
            }
            else
                continue;
        }
        return ans+1;
    }
};