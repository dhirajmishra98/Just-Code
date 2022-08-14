class Solution {
    public boolean isPowerOfThree(int n) {
       return solve(n);
    }
    
    static boolean solve(int n){
       if(n<1)
           return false;
        
        if(n%3==0){
            return solve(n/3);
        }
        
        return n==1;
    }
}