class Solution {
public:
    int singleNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int i;
        if(nums.size()==1)
            return nums[0];
        else{
        for( i=0;i<nums.size();i+=2){
            if(nums[i]!=nums[i+1])
                break;
        }
        }
        return nums[i];
    }
};