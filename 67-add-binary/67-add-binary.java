class Solution {
    public String addBinary(String a, String b) {
        
        String result = "";
        int carry=0,i=0;
        int alen = a.length(),blen=b.length();
        while(i<alen || i<blen || carry!=0){
            int x=0;
            if(i<alen && a.charAt(alen-i-1)=='1') x=1;
            int y=0;
            if(i<blen && b.charAt(blen-i-1)=='1') y=1;
            
            result = (x+y+carry)%2+result;
            carry = (x+y+carry)/2;
            i++;
        }
        return result;
        
    }
}