class Solution {
public:
    string interpret(string command) {
        string ans="";
        for(int i=0;i<command.length();++i){
            
            if(command[i] == '(' && command[i+1]==')'){
                    ans = ans+"o";
                     i++;    
            }
            else if(command[i]!='(' && command[i]!=')')
                 ans = ans+command[i];
            
        }
        return ans;
    }
};