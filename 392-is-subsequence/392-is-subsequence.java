class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0 ) return true;
        if(t.length()==0) return false;
        if(s.length()>t.length()) return false;
        
        int k=0;
        for(int i=0;i<t.length()&& k<s.length() ;i++){
            if(t.charAt(i) == s.charAt(k)){
                k++;
            }
        }
        return (k==s.length());
    }
}
