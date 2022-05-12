class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        unordered_map<int,int> m1,m2,m3;
        for(auto i : nums1)
            m1[i]++;
        for(auto i : nums2)
            m2[i]++;
        for(auto i : nums3)
            m3[i]++;
        
        vector<int> ans;
        for(int i=1;i<101;i++){
            if((m1[i]>0 && m2[i]>0) || (m2[i]>0 && m3[i]>0) || (m3[i]>0 && m1[i]>0))
                ans.push_back(i);
        }
        return ans;
    }
};