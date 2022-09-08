class Solution {
    public int reverse(int x) {
        long rev = 0;
        while(x!=0){
            int rem = x%10;
            x /= 10;
            rev = rev*10+rem;
        }
        if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE)
                return 0;
            
        return (int)rev;
    }
}

/*
//approach 2 (Math)
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x!=0){
            int rem = x%10;
            x /= 10;
            
            if(rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && rem>7)) return 0;
            
            if(rev < Integer.MIN_VALUE/10 || (rev ==Integer.MIN_VALUE/10 && rem <-8 )) return 0;
            
            rev = rev*10+rem;
        }
        return rev;
    }
}
*/


/*
Approach 1 (Java Libararies)
class Solution {
    public int reverse(int x) {
        String rev = new StringBuilder().append(Math.abs(x)).reverse().toString();
        
        try{
            return (x<0)?Integer.parseInt(rev)*-1:Integer.parseInt(rev);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
*/