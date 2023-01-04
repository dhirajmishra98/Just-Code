//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
        if(n==1) return intervals[0][2];
        
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return memoization(0,n,intervals,dp);
    }
    
    private static int memoization(int ind, int n, int[][] intervals, int[] dp){
        if(ind >= n) return 0;
        if(dp[ind] != -1) return dp[ind];
        
        int notPick = memoization(ind+1,n,intervals,dp);
        int nextValidIndex = findnext(ind+1,intervals[ind][1],intervals,n);
        int pick = intervals[ind][2] + memoization(nextValidIndex,n,intervals,dp);
        
        return dp[ind] = Math.max(notPick, pick);
    }
    
    private static int findnext(int index, int lastEnd , int[][] intervals, int n){
        while(index < n){
            if(intervals[index][0] >= lastEnd) return index;
            index++;
        }
        return index;
    }
}
