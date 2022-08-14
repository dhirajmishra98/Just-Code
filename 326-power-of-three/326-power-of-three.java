class Solution {
    public boolean isPowerOfThree(int n) {
       // return solve1(n);
        return solve2(n);
    }
    
   // static boolean solve1(int n){
//        if(n<1)
//            return false;
        
//         if(n%3==0){
//             return solve(n/3);
//         }
        
//         return n==1;
//     }
    
    static boolean solve2(int n){
        double i = (Math.log10(n)/Math.log10(3));
        
        if(i%1==0)
            return true;
        else
            return false;
    }
}