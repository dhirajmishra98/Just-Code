class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
         int index=-1;
        int max = INT_MAX;
        for(int i=0;i<points.size();i++){
            for(int j=0;j<points[i].size();j++){
                if(x==points[i][0] && y==points[i][1])
                    return i;
                else if (x==points[i][0] || y==points[i][1]){
                   int distance = abs(x-points[i][0])+abs(y-points[i][1]);
                if(max > distance)
                {
                    max = distance;
                                index=i;
                            }
                }
                
            }
        }
       return index;
    }
};