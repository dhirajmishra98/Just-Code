class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
       unordered_set<int> s(nums1.begin(),nums1.end());
        vector<int> ans;
        
        for(auto num : nums2){
            if(s.find(num) != s.end())
                ans.push_back(num);
            s.erase(num);
        }
        return ans;
    }
};