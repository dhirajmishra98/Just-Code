//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.minDifference(N, A); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long minDifference(int N, int A[]) 
    { 
        long []prefix = new long[N];
        prefix[0] = A[0];
        for(int i=1;i<N;i++){
            prefix[i] = prefix[i-1]+A[i];
        }
        
        long ans=Long.MAX_VALUE, w,x,y,z;
        for(int i=2;i<N-1;i++){
            int index = getMinDiffIndex(prefix,0,i-1,prefix[i-1],0);
            w = prefix[index];
            x = prefix[i-1]-w;
            
            index = getMinDiffIndex(prefix,i,N-1,prefix[N-1],prefix[i-1]);
            y= prefix[index]-prefix[i-1];
            z = prefix[N-1]-prefix[index];
            
            ans = Math.min(ans, Math.max(Math.max(w,x),Math.max(y,z))-Math.min(Math.min(w,x),Math.min(y,z)));
        }
        
        return ans;
    }
    
    private int getMinDiffIndex(long[] prefix, int low, int high, long sum, long temp){
        long diff=Long.MAX_VALUE;
        int index=-1,mid;
        while(low<=high){
            mid =low+(high-low)/2;
            long first = prefix[mid]-temp;
            long second = sum - prefix[mid];
            
            if(Math.abs(first-second)<diff){
                index = mid;
                diff = Math.abs(first-second);
            }
            
            if(first<second){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return index;
    }
} 