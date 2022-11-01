class Solution {
    public boolean isPowerOfTwo(int n) {
        // long ans = 1;
        // while(ans < n){
        //     ans *= 2;
        // }
        // return ans==n;
        
        return n>0 && (n&(n-1)) == 0;
    }
}