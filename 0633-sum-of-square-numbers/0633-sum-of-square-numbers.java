public class Solution {
    public boolean judgeSquareSum(int c) {
        
        for(long i=0;i*i <= c;i++){
            double b = Math.sqrt(c-i*i);
            if(b == (int)b) return true;
        }
        return false;
        
        /*
        //brute force 1
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
        */
    }
}