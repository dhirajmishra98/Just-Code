class Solution {
    public int countPoints(String rings) {
        HashMap<Character,HashSet<Character>> m = new HashMap<>();
        
        for(int i=1;i<rings.length();i+=2){
            m.putIfAbsent(rings.charAt(i),new HashSet());
            HashSet s = m.get(rings.charAt(i));
            s.add(rings.charAt(i-1));
            m.put(rings.charAt(i),s);
        }
        
        int result = 0;
        for(Set<Character> x : m.values()){
            if(x.size()==3) result ++;
        }
        return result ;
    }
}