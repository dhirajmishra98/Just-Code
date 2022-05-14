class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int,int> m;
        for(auto &i : arr)
            m[i]++;
        
        set<int> s;
        for(auto &j : m)
            s.insert(j.second);
        
        if(s.size()==m.size()) return true;
        return false;
    }
};