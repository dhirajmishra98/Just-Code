class Solution {
    public boolean isPowerOfFour(int n) {
        // return solve(n);
        return solve2(n);
        
    }
    
    // static boolean solve(int n){
    //     return (Math.log10(n)/Math.log10(4)) % 1 == 0;
    // }
    
    static boolean solve2(int n){
        if(n<1)
            return false;
        if(n%4==0)
            return solve2(n/4);
        
        return n==1;
    }
}