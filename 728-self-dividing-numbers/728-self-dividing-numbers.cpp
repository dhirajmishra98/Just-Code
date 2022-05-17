class Solution {
    public:
    bool check(int i){
        if(i==0)
            return false;
        else{
        int temp = i;
        while(temp!=0){
           int rem = temp%10;
            if(rem==0)
                return false;
            if(i%rem!=0)
                return false;
            temp = temp/10;
        }
        return true;
        }
    }
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> ans;
         for(int i=left;i<=right;i++){
             if(check(i))
                 ans.push_back(i);  
         }
        return ans;
    }
};