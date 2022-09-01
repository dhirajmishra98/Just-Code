class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                arr.add(i);
            }
        }
        
        int []result = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int min = Integer.MAX_VALUE;
            for(Integer x : arr){
                min = Math.min(min, Math.abs(x-i));
            }
            result[i] = min;
        }
        return result;
    }
}