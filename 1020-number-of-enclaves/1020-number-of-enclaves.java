class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count_initial = 0;
        
        int[][] visited = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0 || i==row-1 || j==col-1){
                    if(grid[i][j] == 1){
                        dfs(i,j,visited,grid);
                    }
                }
            }
        }
        
        int grid_ones = 0;
        for(int []r : grid){
            for(int x : r){
                if(x==1) grid_ones++;
            }
        }
        
        int visited_ones = 0;
        for(int []r : visited){
            for(int x : r){
                if(x==1) visited_ones++;
            }
        }
        
        return grid_ones-visited_ones;
    }
    
    private void dfs(int row, int col, int[][] visited, int[][]grid){
        visited[row][col] = 1;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
                dfs(nrow,ncol,visited,grid);
        }
    }
}