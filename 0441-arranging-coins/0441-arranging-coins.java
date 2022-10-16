class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long mid,k;
        while(start <= end){
            mid = start + (end-start)/2;
            k = mid*(mid+1)/2;
            
            if(n == k) return (int)mid;
            
            if( n < k)  end = mid-1;
            else start = mid+1;
        }
        return (int)end;
    }
}