class Solution {
public:
    int arraySign(vector<int>& nums) {
        double product =1;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0)
                return 0;
            else{
                product =product * nums[i];
            }
        }
        if(product > 0)
            return 1;
        else
            return -1;
    }
};