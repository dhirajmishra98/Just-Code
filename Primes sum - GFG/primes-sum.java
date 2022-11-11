//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isSumOfTwo(int N){
        if(N%2==0) return "Yes";
        else{
            return checkPrime(N-2);
        }
    }
    
    private static String checkPrime(int n){
        if(n==2) return "Yes";
        
        for(int i=2;i<n;i++){
            if(n%i==0) return "No";
        }
        return "Yes";
    }
}