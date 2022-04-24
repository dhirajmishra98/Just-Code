class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string ans;
        int minLength = min(word1.length(),word2.length());
        for(int i=0;i<minLength;i++){
            if(i%2==0){
                ans = ans+word1[i];
                ans = ans+word2[i];
            }
            else{
                ans = ans+word1[i];
                ans = ans+word2[i];
                
            }
        }
        if(word1.length() > minLength)
        {
            for(int i=minLength;i<word1.length();i++)
                ans = ans+word1[i];
        }
           if(word2.length() > minLength)
        {
            for(int i=minLength;i<word2.length();i++)
                ans = ans+word2[i];
        }
        return ans;
    }
};