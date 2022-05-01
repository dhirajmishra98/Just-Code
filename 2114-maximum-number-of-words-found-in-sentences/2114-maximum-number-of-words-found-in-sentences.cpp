class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        int max = 0;
        for(int i=0;i<sentences.size();i++){
           int  countSpace = count(sentences[i].begin(),sentences[i].end(),' ');
            if(max < countSpace+1)
                max = countSpace+1;
        }
        return max;
    }
};