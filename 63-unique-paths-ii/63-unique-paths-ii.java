class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
       
        /*
        int[][] dp = new int[row][col];
        for(int []dhiraj : dp){
            Arrays.fill(dhiraj,-1);
        }
        return memoise(row-1,col-1,arr,dp);
         */
        /*
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0) dp[i][j] = 1;
               else if(arr[i][j] == 1) dp[i][j]=0;
                else {
                    int down=0,right=0;
                    if(i>0) down = dp[i-1][j];
                    if(j>0) right = dp[i][j-1];
                    dp[i][j] = down+right;
                }
            }
        }
        return dp[row-1][col-1];
        */
        int []prev = new int[col];
        for(int i=0;i<row;i++){
            int []curr = new int[col];
            for(int j=0;j<col;j++){
                if(i>=0 && j>=0 && arr[i][j] == 1) curr[j] = 0;
                else if(i==0 && j==0) curr[j]=1;
                else {
                    int down=0,right=0;
                    if(i>0) down = prev[j];
                    if(j>0) right = curr[j-1];
                    curr[j] = down+right;
                }
            }
            prev = curr;
        }
        return prev[col-1];
    }
    
    private static int memoise(int i, int j, int[][] arr, int [][]dp){
        if(i==0 && j==0 ) return 1;
        if(i<0 || j<0) return 0;
        if(i>=0 && j>=0 && arr[i][j] == 1) return 0;
        if(dp[i][j] != -1 ) return dp[i][j];
        
        int sum = memoise(i-1,j,arr,dp)+memoise(i,j-1,arr,dp);
        return dp[i][j] = sum;
    }
}