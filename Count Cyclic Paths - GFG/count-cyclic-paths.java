//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
	    if(N==1) return 0;
	    if(N==2) return 3;
		long temp1 = 0, temp2 = 3, mod = (int)1e9+7;
		long ans = 0;
		
		for(int i=3;i<=N;i++){
		    ans = ((2*temp2)%mod + (3*temp1)%mod)%mod;
		    temp1 = temp2;
		    temp2 = ans;
		}
		return  (int)(ans% mod);
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends