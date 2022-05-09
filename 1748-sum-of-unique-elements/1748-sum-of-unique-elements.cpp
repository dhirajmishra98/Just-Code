class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++)
            m[nums[i]]++;
        
        int ans = 0;
        for(auto &temp : m){
            if(temp.second == 1)
                ans = ans + temp.first;
        }
        return ans;
    }
};