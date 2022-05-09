class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++)
            m[nums[i]]++;
        
        int temp=0,ans;
        for(auto &it : m){
            if(it.second > temp){
                temp = it.second;
                ans = it.first;
            }
        }
        return ans;
    }
};