class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
       vector<int> ans;
        int i,j;
        bool dhiraj = false;
        for(i=0;i<nums1.size();i++){
            for(j=0;j<nums2.size();j++){
                
                if(dhiraj && nums2[j] > nums1[i]){
                    ans.push_back(nums2[j]);
                    dhiraj= false;
                    break;
                }
                if(nums2[j] == nums1[i])
                    dhiraj = true;
            }
            if(dhiraj){
                ans.push_back(-1);
                dhiraj = false;
            }
        }
        return ans;
    }
};