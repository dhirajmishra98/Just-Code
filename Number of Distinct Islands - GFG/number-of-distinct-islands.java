//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] visited = new int[row][col];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j] == 0 && grid[i][j]==1){
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i,j,grid,visited,arr,i,j);
                    set.add(arr);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int r, int c, int[][]grid, int[][]visited,ArrayList<String> arr,int ibase,int jbase){
        visited[r][c] = 1;
        arr.add(toString(r-ibase,c-jbase));
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = r+delrow[i];
            int ncol = c+delcol[i];
            
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,visited,arr,ibase,jbase);
            }
        }
    }
    
    private String toString(int x, int y){
        return Integer.toString(x)+" "+Integer.toString(y);
    }
}
