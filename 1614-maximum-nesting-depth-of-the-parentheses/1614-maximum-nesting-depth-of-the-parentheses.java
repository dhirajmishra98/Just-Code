class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int temp = st.size();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            if(s.charAt(i)==')'){
                st.pop();
            }
            if(temp<st.size()){
                temp = st.size();
            }
        }
        return temp;
    }
}