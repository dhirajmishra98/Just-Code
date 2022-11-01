class Solution {
    public boolean isPowerOfTwo(int n) {
        long ans = 1;
        while(ans < n){
            ans *= 2;
        }
        return ans==n;
    }
}