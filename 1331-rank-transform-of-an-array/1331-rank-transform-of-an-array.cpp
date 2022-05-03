class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        if(arr.size()==0)
            return {};
        else{
       vector<int> temp = arr;
        sort(temp.begin(),temp.end());
        
        unordered_map<int,int> m;
        m[temp[0]] =0;
        for(int i=1;i<arr.size();i++){
            if(temp[i]!=temp[i-1])
                m[temp[i]] = m[temp[i-1]]+1;
        }
        
        temp.clear();
        for (const int &n : arr)
            temp.push_back(m[n] + 1);
        return temp;
        }
    }
};