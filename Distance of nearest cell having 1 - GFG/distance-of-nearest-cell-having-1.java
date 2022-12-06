//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    class Pair{
        int row,col,distance;
        Pair(int row,int col,int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    
    public int[][] nearest(int[][] mat)
    {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] ans = new int[row][col];
        boolean[][] visited =new boolean[row][col];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(q.size()>0){
            int r = q.peek().row;
            int c = q.peek().col;
            int dis = q.peek().distance;
            ans[r][c] = dis;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+delrow[i];
                int ncol = c+delcol[i];
                
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && visited[nrow][ncol]==false){
                        visited[nrow][ncol] = true;
                        q.add(new Pair(nrow,ncol,dis+1)); 
                }
            }
        }
        return ans; 
    }
}