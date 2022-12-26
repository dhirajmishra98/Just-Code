//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    ArrayList<Long> arr = new ArrayList<>();
    void precompute(){
        for(long i=0;i<63;i++){
            for(long j=i+1;j<63;j++){
                for(long k=j+1;k<63;k++){
                    arr.add((long)Math.pow(2,i)+(long)Math.pow(2,j)+(long)Math.pow(2,k));
                }
            }
        }
        Collections.sort(arr);
    }
    long solve(long L, long R){
        int indexL = Collections.binarySearch(arr,L);
        indexL = indexL<0 ? -indexL-1 : indexL;
        
        
        int indexR = Collections.binarySearch(arr,R);
        indexR = indexR<0 ? -indexR-2 : indexR;
        
        return indexR-indexL+1;
        
    }
    
}
