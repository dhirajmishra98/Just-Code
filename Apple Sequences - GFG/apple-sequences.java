//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        int i=0,j=0,countO=0,result = Integer.MIN_VALUE;
        while(j<n){
            // if(countO<=m){
                
                if(arr.charAt(j)=='O') countO++;
            // }
            
            while(countO>m){
                if(arr.charAt(i)=='O') countO--;
                i++;
            }
            
            
            result = Math.max(result,j-i+1);
            j++;
        }
        return result;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends