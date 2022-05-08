class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        if(nums.size()<=1 || k==1)
            return 0;
        
        sort(nums.begin(),nums.end());
        int ans = INT_MAX;
        for (int i = 0; i <= nums.size() - k; i++)
        {
            ans = std::min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
};