class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int x = 0; x<s.length(); x++){
            map.put(s.charAt(x),map.getOrDefault(s.charAt(x),0)+1);
        }
        
        int check = map.get(map.keySet().toArray()[0]);
        for(Integer x : map.values()){
            if(x != check) return false;
        }
        
        return true;
    }
}