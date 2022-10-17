class Solution {
    class Pair{
        int soldiers;
        int index;
        Pair(int s, int i){
            this.soldiers = s;
            this.index = i;
        }
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        Pair []arr = new Pair[mat.length];
        for(int i=0;i<mat.length;i++){
            int sum = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    sum++;
                } else {
                    break;
                }
            }
            arr[i] = new Pair(sum,i);
        }
        
        //sorting pair, less soldiers->more soldiers(ascending)
        Arrays.sort(arr, (a,b)->a.soldiers-b.soldiers);
        
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = arr[i].index;
        }
        return result;
    }
}