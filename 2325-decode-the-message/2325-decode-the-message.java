class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> m = new HashMap<>();
        Character ch = 97;
        for(int i=0;i<key.length();i++){
            if(key.charAt(i) != ' '){
                if(!m.containsKey(key.charAt(i))){
                    m.put(key.charAt(i), ch);
                    ch++;
                }
            }
            
        }

        StringBuilder str = new StringBuilder();
        for(int i=0;i<message.length();i++){
            if(message.charAt(i) == ' '){
                str.append(' ');
            } else {
                str.append(m.get(message.charAt(i)));
            } 
        }
       return str.toString();
    }
}