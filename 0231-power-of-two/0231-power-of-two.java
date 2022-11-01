class Solution {
    public boolean isPowerOfTwo(int n) {
        // long ans = 1;
        // while(ans < n){
        //     ans *= 2;
        // }
        // return ans==n;
        
        // return n>0 && (n&(n-1)) == 0;
        
        int count = 0;
        while(n>0){
            int temp = n&1;
            if(temp==1) count++;
            n = n>>1;
        }
        return count==1;
    }
}