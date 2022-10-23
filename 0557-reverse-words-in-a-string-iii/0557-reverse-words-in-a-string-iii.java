class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length;i++){
            StringBuilder temp = new StringBuilder();
            temp.append(str[i]);
            result.append(temp.reverse()+" ");
        }
        return result.toString().stripTrailing();
        
        /*
        //BruteForce : TC=O(N) , SC=O(2N)
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
        */
    }
}