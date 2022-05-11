class Solution {
public:
    int smallestEqual(vector<int>& nums) {
        vector<int> temp;
        for(int i=0;i<nums.size();i++){
            if(i%10 == nums[i])
                temp.push_back(i);
        }
        if(temp.empty())
            return -1;
        sort(temp.begin(),temp.end());
        return temp[0];
    }
};