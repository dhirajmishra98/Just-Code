class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        //cannot use hashmap or hashset but using hashtable
        int[] check= new int[256];
        for(int i=0;i<s.length();i++){
            check[s.charAt(i)-'a']++;
            check[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<check.length;i++){
            if(check[i]!=0) return false;
        }
        return true;
    }
}