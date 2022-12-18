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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long maxGcd(int n) {
        //Brute Force : TC=O(N4), SC=O(1) -> TLE
        long N = n;
        long ans1 = 0;
        long ans2 = 0;
        /*
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    for(int l=1;l<=N;l++){
                        long x = gcd(i,j);
                        long y = gcd(k,l);
                        long z = gcd(x,y);
                        
                        ans = Math.max(ans,z);
                    }
                }
            }
        }
        */
        
        //Optimized Approach : TC=O(logN), SC=O(1)
        //we have to check max lcm got from two Approaches
        
        ans1 = method1(N,N-1,N-2,N-3);
        ans2 = method2(N);
        
        return Math.max(ans1,ans2);
    }
    
    private long method2(long N){
        long tempGcd = (N*(N-1))/gcd(N,N-1);
        long count = 2;
        for(long i=N-2;i>=1 && count>0 ;i--){
            if(gcd(tempGcd,i)==1L){
                tempGcd = tempGcd*i;
                count--;
            }
        }
        return tempGcd;
    }
    
    private long method1(long i, long j, long k, long l){
        long x =(i*j)/gcd(i,j);
        long y =(k*l)/gcd(k,l);
        return (x*y)/gcd(x,y);
    }
    
    private long gcd(long a, long b){
        //Euclid Optimized Approach : TC=O(log(max(a,b)))
         if (a == 0)
            return b;
 
        return gcd(b % a, a);
    }
}