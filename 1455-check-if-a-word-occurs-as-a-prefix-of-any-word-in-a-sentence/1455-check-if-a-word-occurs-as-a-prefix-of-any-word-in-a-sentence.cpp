class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        if(searchWord.size()>sentence.size()) return -1;
        int countSpace = 0,k=0;
        for(int i=0;i<sentence.size();i++){
            if(sentence[i]==' ')
                countSpace++;
           for(int j=0;j<searchWord.size();j++){
               if((searchWord[j]==sentence[i+j]) &&  ( i==0 || sentence[i-1]==' '))
                   k++;
               else
                   break;
           }
            if(k==searchWord.size())
                return countSpace+1;
            else
                k=0;
        }
        return -1;
    }
};