class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder("");
        
        StringBuilder temp = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                temp.append(s.charAt(i));
            }else {
                result.append(temp.reverse());
                result.append(" ");
                // temp = new StringBuilder("");
                temp.setLength(0);
            }
        }
         result.append(temp.reverse());
               
        return result.toString();
    }
}