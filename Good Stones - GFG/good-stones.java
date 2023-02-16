//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public int goodStones(int n, int[] arr) {
        // code here
        int[] dp = new int[n]; //0-unvisited, 1-visited and gets in loop, 2-good stones
        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(dp[i]==0) helper(i,n,arr,dp);
            if(dp[i]==2) count++;
        }
        
        return count;
    }
    
    private boolean helper(int i, int n, int[] arr, int []dp){
        if(i<0 || i>=n || dp[i]==2) return true; //if out of river or at any index which get us out of river then return true
        if(dp[i]==1) return false; //if its get in loop and visited
        
        dp[i] = 1;
        boolean flag  = helper(i+arr[i],n,arr,dp);
        if(flag) { //means we reached to destination through ith index
            dp[i] = 2; //again reset ith index from visited to goodstones
        }
        
        return flag; //else return false which will effect nothing already dp[i]=1, marked as false
    }
}
        
