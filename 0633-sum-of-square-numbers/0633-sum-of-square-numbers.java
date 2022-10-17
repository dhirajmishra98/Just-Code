public class Solution {
    public boolean judgeSquareSum(int c) {
        
        for(long i=0;i*i <= c; i++){
            long b = c-i*i;
            boolean check = binarySearch(0,b,b);
            if(check) return true;
        }
        return false;
        
        /*
        //optimized Brute force 2
        for(long i=0;i*i <= c;i++){
            double b = Math.sqrt(c-i*i);
            if(b == (int)b) return true;
        }
        return false;
        */
        
        /*
        //Brute force 1
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
        */
    }
    
    private boolean binarySearch(long start, long end, long target){
        while(start<=end){
            long mid = start + (end-start)/2;
            if(mid*mid == target) return true;
            else if(mid*mid > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}