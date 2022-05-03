class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        string ans="";
        for(int i=0;i<words.size();i++)
            if(checkPalindrome(words[i]))
                return words[i];
        
        return ans;
    }
    
    bool checkPalindrome(string s){
        int i;
        for(i=0;i<s.size();i++)
            if(s[i] != s[s.size()-i-1])
                break;
        
        if(i==s.size())
            return true;
        else
            return false;
    }
};