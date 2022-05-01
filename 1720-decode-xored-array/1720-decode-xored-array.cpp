class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        vector<int> decode = {first};

        for(int i=0;i<encoded.size();i++)
            decode.push_back(decode[i] ^ encoded[i]);
        
        return decode;
    }
};