class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if(nums[y]!=0){
                int temp = nums[y];
                nums[y] = 0;
                nums[x] = temp;
                x++;
            }
            y++;
            
        }
    } 
};