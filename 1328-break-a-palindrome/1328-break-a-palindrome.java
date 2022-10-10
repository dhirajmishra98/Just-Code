class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";
        
        char []p = palindrome.toCharArray();
        
        for(int i=0;i<palindrome.length();i++){
            if(p[i] != 'a' && i<palindrome.length()/2){
                p[i]='a';
                String temp = String.valueOf(p);
                return temp;
            }
        }

        p[palindrome.length()-1] = 'b';
        return String.valueOf(p);
    }
}