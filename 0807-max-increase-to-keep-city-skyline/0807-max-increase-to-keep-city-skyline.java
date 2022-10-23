class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int []rowMax = new int[grid.length];
        int []colMax = new int[grid.length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                colMax[i] = Math.max(colMax[i],grid[j][i]);
            }
        }
        System.out.println(Arrays.toString(rowMax));
        System.out.println(Arrays.toString(colMax));
        
        
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                ans += Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return ans;
    }
}