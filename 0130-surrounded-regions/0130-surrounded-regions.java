class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        int[][] visited = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(board[i][j] == 'O'){
                        dfs(i,j,board,visited);
                    }
                }
            }
        }
            
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }  
    }
    
    private void dfs(int r,int c, char[][] board, int[][]visited){
        visited[r][c] = 1;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = r+delrow[i];
            int ncol = c+delcol[i];
            
            
                if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]=='O'){
                    if(visited[nrow][ncol] == 0){
                dfs(nrow,ncol,board,visited);
            }
            } 
        }
    }

}