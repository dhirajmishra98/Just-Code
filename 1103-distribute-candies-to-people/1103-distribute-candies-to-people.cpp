class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        vector<int> ans(num_people,0);
        int i=0,start=1;
        while(candies){
            if(start<candies){
                ans[i]+=start;
                candies-=start;
                start++;
            }
            else{
                ans[i]+=candies;
                candies=0;
            }
            i++;
            if(i==num_people)
                i=0;
        }
        return ans;
    }
};