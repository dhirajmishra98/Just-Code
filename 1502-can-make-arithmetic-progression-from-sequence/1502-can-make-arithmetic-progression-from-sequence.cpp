class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        int diff = arr[0]-arr[1];
        int i;
        for( i=1;i<arr.size()-1;i++){
            if(arr[i]-arr[i+1] == diff)
                continue;
            else
                break;
        }
        if(i==arr.size()-1)
            return true;
        else
            return false;
    }
};