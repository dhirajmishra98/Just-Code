class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        int[][] visited = new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                   int temp = dfs(i,j,grid,visited);
                    ans = Math.max(ans,temp);
                }
            }
        }
        
        return ans;
    }
    
    private int dfs(int r, int c, int[][] grid, int[][] visited){
        if(r<0 || c<0 || r>grid.length || c>grid[0].length || visited[r][c]==1 || grid[r][c]==0) 
            return 0;
        
        visited[r][c]  = 1;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        int count = 1;
        for(int i=0;i<4;i++){
            int nrow = r+delrow[i];
            int ncol = c+delcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                 count+=dfs(nrow,ncol,grid,visited);
            }
        }
        return count;
    }
}