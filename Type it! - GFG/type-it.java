//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        if(s.length()<=2) return s.length();
        int maxi = 0;
        for(int i=0;i<s.length();i++){
            String ss = s.substring(0,i+1);
            if(i+i+2 < s.length()){
                String str = s.substring(i+1,i+i+2);
                if(str.equals(ss)){
                maxi = Math.max(maxi,i+1);
                }
            }
        }
        if(maxi == 0)
        return s.length();
        return s.length()-maxi+1;
    }
}