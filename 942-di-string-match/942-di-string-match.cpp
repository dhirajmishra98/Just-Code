class Solution {
public:
    vector<int> diStringMatch(string s) {
        vector<int> ans;
        int init = 0,final=s.size();
        
        for(int i=0;i<=s.size();i++){
            if(s[i]=='I'){
                ans.push_back(init);
                init++;
            }
            else{
                ans.push_back(final);
                final--;
            }
        }
        return ans;
    }
};