class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int []row : dp){
        //     Arrays.fill(row,-1);
        // }
        
        // return memoise(m-1,n-1,dp); //memoization
        
        // for(int i=0;i<m;i++){ //Tabulation
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0) dp[i][j] = 1;
        //         else {
        //             int up =0, left =0;
        //             if(i>0) up = dp[i-1][j];
        //             if(j>0) left = dp[i][j-1];
        //             dp[i][j] = up+left;
        //         }
        //     }
        // }
        // return dp[m-1][n-1];
        
        int []prev = new int[n];
        for(int i=0;i<m;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j] = 1;
                else{
                    int up=0,left = 0;
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
    
    private static int memoise(int i, int j,int [][]dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = memoise(i-1,j,dp);
        int left = memoise(i,j-1,dp);
        
        int sum = up+left;
        return dp[i][j] = sum;
    }
}