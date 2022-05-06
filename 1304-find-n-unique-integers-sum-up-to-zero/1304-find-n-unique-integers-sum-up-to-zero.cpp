class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> ans;
        
        if(n%2==0){
            int k=1;
            for(int i=1;i<=n;i++){
                if(i%2!=0){
                    k++;
                    ans.push_back(k);
                }
                    else
                        ans.push_back(-1*k);
               
            }
        }
        else{
            int k=0;
            for(int i=0;i<n;i++){
                if(i==0)
                    ans.push_back(k);
                else if(i%2!=0){
                    ++k;
                    ans.push_back(k);
                }
                    else
                        ans.push_back(-1*k);
                
            }
        }
        return ans;
    }
};