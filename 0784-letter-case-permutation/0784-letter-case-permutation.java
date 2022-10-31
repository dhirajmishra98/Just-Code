class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        permutation(list,"",s);
        return list;
    }
    
    private void permutation(List<String> list, String p, String up){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        
        char str = up.charAt(0);
        if( !Character.isDigit(str) ){
            char ch = Character.toUpperCase(str);
            permutation(list, p+ch, up.substring(1));
            
        } 
        if( !Character.isDigit(str)){
            char ch = Character.toLowerCase(str);
            permutation(list, p+ch , up.substring(1));
            
        } 
        if(Character.isDigit(str)){
            permutation(list, p+str, up.substring(1));
        }
    }
}