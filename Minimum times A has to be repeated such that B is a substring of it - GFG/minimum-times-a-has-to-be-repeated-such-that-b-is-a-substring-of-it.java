//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        for(int i=0;i<B.length();i++){
            if(!A.contains(String.valueOf(B.charAt(i)))) return -1;
        }
        
        int count = 1;
        StringBuilder str = new StringBuilder(A);
        while(str.length()<B.length()){
            str.append(A);
            count++;
        }
        
        if(str.toString().contains(B)) return count;
        str.append(A);
        count++;
        if(str.toString().contains(B)) return count;
        return -1;
    }
};