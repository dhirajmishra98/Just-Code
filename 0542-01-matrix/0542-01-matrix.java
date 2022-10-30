class Solution {
    class Pair{
        int row,col,distance;
        Pair(int row,int col,int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] ans = new int[row][col];
        boolean[][] visited =new boolean[row][col];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
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