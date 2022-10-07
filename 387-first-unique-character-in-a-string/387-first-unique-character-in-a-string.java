class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> m = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character,Integer> e : m.entrySet()){
            if(e.getValue()==1) return s.indexOf(e.getKey());
        }
        return -1;
    }
}