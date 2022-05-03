class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        unordered_map<int,int> m;
        int ans = 0,maxlen = 0;
        for(int i=0;i<rectangles.size();i++){
            int maxSide = min(rectangles[i][0],rectangles[i][1]);
           m[maxSide]++;
        }
        
        for(auto temp : m){
            if(maxlen<temp.first ){
                maxlen = temp.first;
                ans = temp.second;
            }
            
        }
        return ans;
        
    }
};