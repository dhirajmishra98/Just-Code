//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        int result = 0, i = 0,j=0;
        boolean pos = true;
        
        while(j<=n){
            if(j!=n && arr[j]!=0){
                if(arr[j] < 0) pos = !pos;
                if(pos) result = Math.max(result,j-i+1);
            } else{
                //arr[j]==0
                while(i < j){
                    if(arr[i]<0) pos = !pos;
                    if(pos) result = Math.max(result,j-i-1);
                    i++;
                }
                //else started when arr[j]==0, means after while end i==j and arr[i]==0, so i=j+1
                // to get next element start after 0, also pos reset to true;
                i = j+1;
                pos = true;
            }
            j++;
        }
        return result;
    }
   
}