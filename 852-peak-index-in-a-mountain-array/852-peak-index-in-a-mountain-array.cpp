class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int count=0;
        for(int i=1;i<arr.size()-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                count = i;
                break;
            }
                
        }
        return count;
    }
};