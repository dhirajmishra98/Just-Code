class Solution {
    public int maxDepth(String s) {
        // Stack<Character> st = new Stack<>();
        // int temp = st.size();
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)=='('){
        //         st.push(s.charAt(i));
        //     }
        //     if(s.charAt(i)==')'){
        //         st.pop();
        //     }
        //     if(temp<st.size()){
        //         temp = st.size();
        //     }
        // }
        // return temp;
        
        int res = 0, curr=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                res = Math.max(res,++curr);
            } else if(s.charAt(i)==')'){
                --curr;
            }
        }
        return res;
    }
}