class Solution {
public:
    string sortSentence(string s) {
        string word = "";
        vector<string> sentence(10) ;
        
        for(int i=0;i<s.size();i++){
            
            if(s[i] > 48 &&  s[i]<=57){
                sentence[s[i]-48] = word+" ";
                word="";
                i++;
            } else
            word += s[i];
        }
        string ans ;
        for(string x: sentence){
            ans+=x;
        }
        ans.pop_back();
        return ans;
    }
};