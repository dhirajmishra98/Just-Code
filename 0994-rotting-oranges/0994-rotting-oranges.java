class Solution {
    
    class Pair{
        int row,col,time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int t = 0;
        int countFresh = 0;
        
        int[][] visited = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                
                if(grid[i][j] == 1) countFresh ++;
            }
        }
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int time = 0, gotrotten = 0;
        while(q.size()>0){
            int row = q.peek().row;
            int col = q.peek().col;
            time = Math.max(time, q.peek().time);
            q.poll();
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                   q.add(new Pair(nrow,ncol,time+1));
                    visited[nrow][ncol] = 2;
                    gotrotten++;
                }
            }
        }
        
        if(gotrotten != countFresh) return -1;
        return time;
    }
}