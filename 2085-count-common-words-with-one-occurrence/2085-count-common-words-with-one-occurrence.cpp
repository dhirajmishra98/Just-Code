class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        unordered_map<string,int> m1,m2;
        for(auto &s1 : words1)
            m1[s1]++;
        
        for(auto &s2 : words2)
            m2[s2]++;
        
        int count = 0;
       for(auto &temp : m1){
           if(m1[temp.first]==1 && m2[temp.first]==1)
               count++;
       }
        return count;
    }
};