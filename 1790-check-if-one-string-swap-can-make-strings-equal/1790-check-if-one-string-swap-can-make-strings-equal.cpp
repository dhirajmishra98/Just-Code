class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
              int ct=0,a1=-1,a2,b1,b2;
        for(int k=0;k<s1.length();k++)
        {
            if(s1[k]!=s2[k])
            {
                ct++;
                if(ct>2)
                    return false;
                if(a1==-1)
                {
                    a1=s1[k]-'a';
                    b1=s2[k]-'a';
                }
                a2=s1[k]-'a';
                b2=s2[k]-'a';
            }
        }
        if(ct==0)
            return true;
        if(ct<2)
            return false;
        if(b1==a2 && b2==a1)
            return true;
        return false;  
    }
};