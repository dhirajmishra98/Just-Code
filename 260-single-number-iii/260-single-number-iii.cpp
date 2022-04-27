class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
       unordered_map<int,int> map;
        vector<int> ans;
        int i;
        for(int i=0;i<nums.size();i++){
            map[nums[i]]++;
        }
        
        auto itr = map.begin();
        for(  itr;itr!=map.end();itr++){
            if((itr->second)==1){
                ans.push_back(itr->first);
            }
        }
            return ans;
    }
};