//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        long [][]cost = new long[N][3];
        cost[0][0] = r[0]; cost[0][1] = g[0]; cost[0][2] = b[0];
        
        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if (j==0){
                    cost[i][j] = r[i];
                    cost[i][j] += Math.min(cost[i-1][j+1],cost[i-1][j+2]);
                } else if (j==1){
                    cost[i][j] = g[i];
                    cost[i][j] += Math.min(cost[i-1][j-1],cost[i-1][j+1]);
                } else {
                    cost[i][j] = b[i];
                    cost[i][j] += Math.min(cost[i-1][j-2],cost[i-1][j-1]);
                }
            }
        }
        
        return Math.min(Math.min(cost[N-1][0],cost[N-1][1]),cost[N-1][2]);
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