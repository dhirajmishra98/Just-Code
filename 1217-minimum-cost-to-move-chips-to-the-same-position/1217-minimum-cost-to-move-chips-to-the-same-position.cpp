class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
       int evenpos=0,oddpos=0;
        for(auto &i : position){
            if(i%2==0)
                evenpos++;
            else
                oddpos++;
        }
        return min(evenpos,oddpos);
    }
};