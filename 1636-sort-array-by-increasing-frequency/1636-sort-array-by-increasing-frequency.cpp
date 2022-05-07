class Solution {   
public:
    vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++)
            m[nums[i]]++;
        
        sort(nums.begin(),nums.end(),[&](const int &a,const int &b)
             {
                 if(m[a]<m[b])
                     return true;
                 if(m[a]>m[b])
                     return false;
                return a>b;
             });
        return nums;
    }
};