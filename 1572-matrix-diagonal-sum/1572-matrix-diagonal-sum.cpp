class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int sizem = mat.size();
        int ans = 0;
        
        for(int i=0;i<sizem;i++){
            for(int j=0;j<sizem;j++){
                if(i==j)
                    ans = ans + mat[i][j];
                if((i+j)==(sizem-1) && i!=j)
                    ans = ans + mat[i][j];
            }
        }

        return ans;
    }
};