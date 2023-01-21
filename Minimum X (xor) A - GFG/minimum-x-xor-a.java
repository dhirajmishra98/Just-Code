//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int bit_a = Integer.bitCount(a);
        int bit_b = Integer.bitCount(b);
        
        if(bit_a == bit_b) return a;
        else if(bit_a > bit_b){
            for(int i = a; i>= 0 ;i--){
                if(Integer.bitCount(i)==bit_b) return i;
            }
        } else {
            for(int i=a;i<Integer.MAX_VALUE; i++){
                if(Integer.bitCount(i)==bit_b) return i;
            }
        }
        
        return 0;
    }
}