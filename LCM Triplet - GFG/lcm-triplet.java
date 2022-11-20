//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.lcmTriplets(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long lcmTriplets(long N) {
        if(N<3) return N;
        
        if(N%2 != 0) return N*(N-1)*(N-2);
        else {
            if(gcd(N,N-3) == 1) return N*(N-1)*(N-3);
            else return (N-1)*(N-2)*(N-3);
        }
    }
    
    private long gcd(long x, long y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
}

/*
If n is odd then the answer will be n, n-1, n-2.
If n is even, 
If gcd of n and n-3 is 1 then answer will be n, n-1, n-3.
Otherwise, n-1, n-2, n-3 will be required answer.
*/