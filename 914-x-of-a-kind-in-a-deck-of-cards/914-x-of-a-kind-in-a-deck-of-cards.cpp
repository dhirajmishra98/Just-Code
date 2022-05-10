class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        unordered_map<int,int> m;
        for(int i=0;i<deck.size();i++)
            m[deck[i]]++;
        
       int temp = m[deck[0]];
       for(auto x : m)
           temp = __gcd(temp,x.second);
        
        if(temp<2)
            return false;
        
        for(auto x : m)
            if(x.second%temp !=0 )
                return false;
        
        return true;
    }
};
