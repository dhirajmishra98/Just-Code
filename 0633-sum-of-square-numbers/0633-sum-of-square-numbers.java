public class Solution {
    public boolean judgeSquareSum(int c) {
        //Two pointers approach
        long i=0,j=(long)Math.sqrt(c);
        while(i<=j){
            long curr = i*i + j*j;
            if(curr < c) i++;
            else if(curr > c) j--;
            else return true;
        }
        return false;
        
        /*
        //Binary search
        for(long i=0;i*i <= c; i++){
            long b = c-i*i;
            boolean check = binarySearch(0,b,b);
            if(check) return true;
        }
        return false;
        */
        
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