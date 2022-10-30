class Solution {
    class Pair{
        int row,col,color;
        Pair(int row, int col,int color){
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        
        int[][] ans = new int[row][col];
        ans = image;
        int[][] visited = new int[row][col];
        Queue<Pair> q = new LinkedList<>();
        
        int initial = ans[sr][sc];
        ans[sr][sc] = color;
        visited[sr][sc] = color;
        q.add(new Pair(sr,sc,ans[sr][sc]));
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(q.size() > 0){
            int r = q.peek().row;
            int c = q.peek().col;
            int clr = q.peek().color;
            q.poll();
            
            for(int k=0;k<4;k++){
                int nrow = r+delrow[k];
                int ncol = c+delcol[k];
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && visited[nrow][ncol]!=color && ans[nrow][ncol]==initial){
                    q.offer( new Pair(nrow,ncol,color));
                    ans[nrow][ncol] = color;
                    visited[nrow][ncol] = color;
                }
            }
        }
        return ans;
    }
}