public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
//         StringBuilder s = new StringBuilder();
//            s.append( Integer.toString(n) );
//         s.reverse();
        
//         return Integer.parseInt(s.toString(),2);
        return Integer.reverse(n);
    }
}