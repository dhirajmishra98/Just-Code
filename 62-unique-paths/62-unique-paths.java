class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return memoise(m-1,n-1,dp);
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