class Solution {
    public int firstUniqChar(String s) {
        //TC=O(n)
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
        }
        
        // if you're using LinkedHashMap
        // for(Map.Entry<Character,Integer> e : m.entrySet()){
        //     if(e.getValue()==1) return s.indexOf(e.getKey());
        // }
        
        for(int i=0;i<s.length();i++){
            if(m.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}