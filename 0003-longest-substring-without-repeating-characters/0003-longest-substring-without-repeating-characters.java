class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int ans = 0;
        int i=0,j=0;
        while(j<s.length()){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                j++;
                ans = Math.max(ans,st.size());
            } else {
                    st.remove(s.charAt(i));
                    i++;
            }  
        }
        return ans;
    }
}