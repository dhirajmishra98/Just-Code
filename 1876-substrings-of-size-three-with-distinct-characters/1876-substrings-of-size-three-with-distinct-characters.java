class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        int count = 0,i=0,j=0;
        while(j<s.length()){
             map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            if( (j-i+1) < 3){
                j++;
            } 
            else if( (j-i+1) == 3){
                if(map.size()==3) count++;
                Integer val = map.get(s.charAt(i))-1;
                if(val==0) map.remove(s.charAt(i));
                else{
                    map.put(s.charAt(i),val);
                }
                i++;
            j++;
            }
            
           
        }
        return count;
    }
}