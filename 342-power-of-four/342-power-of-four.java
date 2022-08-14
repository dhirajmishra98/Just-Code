class Solution {
    public boolean isPowerOfFour(int n) {
        return solve(n);
    }
    
    static boolean solve(int n){
        return (Math.log10(n)/Math.log10(4)) % 1 == 0;
    }
}