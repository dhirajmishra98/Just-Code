class Solution {
    int sol(int x){
        if(x<=0)
            return 0;
        int count=0;
        while(x){
            x=x&(x-1);
            count++;
        }
        return count;
    }
public:
    int hammingDistance(int x, int y) {
        int count = x^y;
        return sol(count);  
    }
};