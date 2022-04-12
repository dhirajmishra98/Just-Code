class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        int maxYearPopulation = 1950;
        
        for(int i=0;i<logs.length;i++){
            int birthyear = logs[i][0];
            int deathyear = logs[i][1];
            
            year[birthyear-1950]++;
            year[deathyear-1950]--;
        }
        
        int maxpop = year[0];
        for(int i=1;i<year.length;i++){
            year[i] = year[i]+year[i-1];
            if(maxpop < year[i]){
                maxpop = year[i];
                maxYearPopulation = 1950+i;
            }
        }
        return maxYearPopulation;
    }
}