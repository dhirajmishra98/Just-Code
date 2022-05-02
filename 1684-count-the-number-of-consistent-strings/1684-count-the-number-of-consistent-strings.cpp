class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
       unordered_map<char,char> m;
        int count = 0,i,j;
        
        for(i=0;i<allowed.size();i++)
            m[allowed[i]]  = allowed[i];
        
        for(i=0;i<words.size();i++){
            for(j=0;j<words[i].size();j++){
                if(m.find(words[i][j]) == m.end())
                    break;
            }
            if(j==words[i].size())
                count++;
        }
        return count;
    }
};