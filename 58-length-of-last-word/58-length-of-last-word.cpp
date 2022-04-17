class Solution {
public:
    int lengthOfLastWord(string s) {
        
           int max=0;
        for(int i=s.size()-1;i>=0;i--){
         
            if(s[i]!=' ')
                max++;
            else if(max>0)
                break;
           
        }
        return max;
    
    }
};