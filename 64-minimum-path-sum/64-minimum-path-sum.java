class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int []prev = new int[col];
        for(int i=0;i<row;i++){
            int []curr = new int[col];
            for(int j=0;j<col;j++){
                if(i==0 && j==0) curr[j] = grid[i][j];
                else {
                    int down = 0,right = 0;
                    if(i>0) down = prev[j];
                    else down = Integer.MAX_VALUE;
                    if(j>0) right = curr[j-1];
                    else right = Integer.MAX_VALUE;
                    
                    curr[j] = grid[i][j]+Math.min(down,right);
                }
            }
            prev = curr;
        }
        return prev[col-1];
    }
}