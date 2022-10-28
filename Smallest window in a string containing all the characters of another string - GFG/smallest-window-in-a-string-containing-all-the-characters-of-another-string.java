//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if(s==null || s.length()==0 || p==null || p.length()==0)
        return "-1";
        
        HashMap<Character,Integer> pmap = new HashMap<>();
        char []pat = p.toCharArray();
        char []str = s.toCharArray();
        
        if(pat.length > str.length) return "-1";
        
        for(char x : pat)
            pmap.put(x,pmap.getOrDefault(x,0)+1);
        
        int patlen = 0;
        int i=0,j=0,minlen=Integer.MAX_VALUE;
        int starting_index = 0;
        
        for(j=0;j<str.length;j++){
            if(pmap.containsKey(str[j])){
                pmap.put(str[j],pmap.get(str[j])-1);
              if(pmap.get(str[j]) >= 0)
              patlen++;
            }
            
            while(patlen == pat.length){
                if(j-i+1 < minlen){
                    minlen = j-i+1;
                    starting_index = i;
                }
                
                char charAtStart =str[i++] ;
                if (pmap.containsKey(charAtStart)) {
                if (pmap.get(charAtStart) == 0) {
                    patlen--;
                }
                
                pmap.put(charAtStart, pmap.get(charAtStart) + 1);
            }
            
        }
        // j++;
        }
        
        if (minlen > str.length)
        return "-1";
    
        return s.substring(starting_index, starting_index + minlen);
    }
}