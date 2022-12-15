//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        StringBuilder str = new StringBuilder();
        StringBuilder alphabets = new StringBuilder();
        for(int i=0;i<26;i++){
            alphabets.append((char)('a'+i));
        }
        
        int counter = N/26;
        int extra = N%26;
        
        for(int i=0;i<counter;i++){
            str.append(alphabets);
        }
        
        if(extra%2 == 0){
            for(int i=0;i<extra/2;i++)
                str.append((char)('a'+i));
            for(int i=26-extra/2;i<26;i++)
                str.append((char)('a'+i));
        } else {
            if(isEven(N)){
                for(int i=0;i<(extra+1)/2;i++)
                    str.append((char)('a'+i));
                for(int i=26-(extra-1)/2;i<26;i++)
                    str.append((char)('a'+i));
            } else {
                for(int i=0;i<(extra-1)/2;i++)
                    str.append((char)('a'+i));
                for(int i=26-(extra+1)/2;i<26;i++)
                    str.append((char)('a'+i));
            }
        }
        
        return str.toString();
    }
    
    private static boolean isEven(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum += rem;
            n /= 10;
        }
        
        if(sum%2==0) return true;
        return false;
    }
}