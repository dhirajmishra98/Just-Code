class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index=-1;
        int max = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[i].length;j++){
                if(x==points[i][0] && y==points[i][1])
                    return i;
                else if (x==points[i][0] || y==points[i][1]){
                   int distance = Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(max > distance)
                {
                    max = distance;
                                index=i;
                            }
                }
                
            }
        }
       return index;
    }
}