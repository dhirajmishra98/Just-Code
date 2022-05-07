class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        unordered_map<int,int> m;
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]==key)
                m[nums[i+1]]++;
        }
        
        int freqCount=0;
        int dhiraj;
        for(auto &temp : m){
            if(temp.second > freqCount){
                freqCount = temp.second;
                dhiraj = temp.first;
            }
        }
        return dhiraj;
        
        
    }
};