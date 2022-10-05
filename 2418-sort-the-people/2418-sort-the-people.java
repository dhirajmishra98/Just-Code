class Solution {
    class Pair{
        String names;
        int heights;
        Pair(String names, int heights){
            this.names = names;
            this.heights = heights;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] arr = new Pair[names.length];
        for(int i=0;i<names.length;i++){
            arr[i] = new Pair(names[i],heights[i]);
        }
        
        Arrays.sort(arr, (a,b)->b.heights-a.heights);
       
        String []str = new String[names.length];
        for(int i=0;i<names.length;i++){
            str[i] = arr[i].names;
        }
        return str;
    }
}