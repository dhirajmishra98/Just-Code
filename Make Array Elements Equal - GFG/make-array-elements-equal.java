//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        // Code here
        // Code here
        // 2-1
        // 3-2
        // 4-4
        // 5-6
        // 6-9
        // 7-12
        // 8-16 8%2==0 then ans*ans, else ans*ans+1
        
        long temp = N/2;
        if(N%2==0){
            return(long) temp*temp;
        }else{
            return(long) temp*(temp+1);
        }
    }
}