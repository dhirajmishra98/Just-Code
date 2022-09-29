class Solution {
    static int[][] dp = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
       return helper(text1.length()-1,text2.length()-1,text1,text2);
    }
    private static int helper(int i, int j, String s1, String s2){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = helper(i-1,j,s1,s2);
        ans = Math.max(ans, helper(i,j-1,s1,s2));
        ans = Math.max(ans, helper(i-1,j-1,s1,s2)+((s1.charAt(i)==s2.charAt(j))?1:0)) ;
        
        return dp[i][j] = ans;
    }
}