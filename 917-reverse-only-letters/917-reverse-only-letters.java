class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] str = s.toCharArray();
        
        while(start <= end){
            if(!Character.isLetter(str[start])){
                start++;
            }
            
            else if(!Character.isLetter(str[end])){
                end--;
            } 
            
            else {
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
        }
        return new String(str);
    }
}