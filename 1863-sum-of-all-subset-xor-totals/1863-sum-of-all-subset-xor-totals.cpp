class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        vector<int> empty;
        int ans =0;
         generate(empty,0,nums,ans);
        return ans;
    }
private:
    void generate(vector<int> &empty,int i,vector<int> &nums,int &ans){
        int sum = 0;
        for(auto x: empty)
            sum = sum^x;
       ans = ans+sum;
        
        for(i;i<nums.size();i++){
            empty.push_back(nums[i]);
            
            generate(empty,i+1,nums,ans);
            empty.pop_back();
        }
        
    }
};