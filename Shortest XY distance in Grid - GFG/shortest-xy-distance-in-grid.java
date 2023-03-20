//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // Expected Time Complexity: O(N*M)
        // Expected Auxiliary Space: O(N*M)
        
        int result = Integer.MAX_VALUE;
        ArrayList<int[]> x = new ArrayList<>();
        ArrayList<int[]> y = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid.get(i).get(j)=='X') x.add(new int[]{i,j});
                if(grid.get(i).get(j)=='Y') y.add(new int[]{i,j});
            }
        }
        
        for(int i=0;i<x.size();i++){
            for(int j=0;j<y.size();j++){
                result = Math.min(result,Math.abs(x.get(i)[0]-y.get(j)[0]) + Math.abs(x.get(i)[1]-y.get(j)[1]));
            }
        }
        
        return result;
    }
};