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
    void precompute()
    {
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
        //searching L's position in Array
        int l1=0,h1=arr.size()-1, indexL = 0;
        while(l1<=h1){
            int mid1 = l1 + (h1-l1)/2;
            if(arr.get(mid1) >= L){
                indexL = mid1;
                h1 = mid1-1;
            }else {
                l1 = mid1+1;
            }
        }
        
        int l2=0,h2=arr.size()-1, indexR = 0;
        while(l2<=h2){
            int mid2 = l2 + (h2-l2)/2;
            if(arr.get(mid2) <=R){
                indexR = mid2;
                l2 = mid2+1;
            }else {
                h2 = mid2-1;
            }
        }
        
        return indexR-indexL+1;
    }
    
    private long inBuildBinarySearch(long L, long R){
        int indexL = Collections.binarySearch(arr,L);
        indexL = indexL<0 ? -indexL-1 : indexL;
        
        
        int indexR = Collections.binarySearch(arr,R);
        indexR = indexR<0 ? -indexR-2 : indexR;
        
        return indexR-indexL+1;
        
    }
    private boolean helper(long x){
        int count = 0;
        while(x>0){
            if((x&1) == 1) count++;
            x = x>>1;
        }
        if(count == 3) return true;
        return false;
    }
    
}
