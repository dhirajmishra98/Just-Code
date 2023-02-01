//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        long []cost = new long[3];
        cost[0] = r[0]; cost[1] = g[0]; cost[2] = b[0];
        
        for(int i=1;i<N;i++){
            long []temp = new long[3];
            for(int j=0;j<3;j++){
                if (j==0){
                    temp[j] = r[i];
                    temp[j] += Math.min(cost[j+1],cost[j+2]);
                } else if (j==1){
                    temp[j] = g[i];
                    temp[j] += Math.min(cost[j-1],cost[j+1]);
                } else {
                    temp[j] = b[i];
                    temp[j] += Math.min(cost[j-1],cost[j-2]);
                }
            }
            cost = temp.clone();
        }
        
        return Math.min(Math.min(cost[0],cost[1]),cost[2]);
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends