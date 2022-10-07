class Solution {
    public int firstUniqChar(String s) {
        //TC=O(n)
        // HashMap<Character,Integer> m = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
        // }
        // for(int i=0;i<s.length();i++){
        //     if(m.get(s.charAt(i)) == 1) return i;
        // }
        // if you're using LinkedHashMap
        // for(Map.Entry<Character,Integer> e : m.entrySet()){
        //     if(e.getValue()==1) return s.indexOf(e.getKey());
        // }
        
        //hashtable
        int []check = new int[26];
        for(int i=0;i<s.length();i++){
            check[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(check[index]==1) return i;
        }
        
        return -1;
    }
}