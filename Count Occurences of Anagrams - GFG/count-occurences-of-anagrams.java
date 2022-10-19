//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int count = 0;
        int []pattern = new int[26];
        int []text = new int[26];
        
        for(int x=0;x<pat.length();x++){
            pattern[pat.charAt(x)-'a']++;
            text[txt.charAt(x)-'a']++;
        }
 
        if(Arrays.equals(pattern,text)) count++;
        for(int i=pat.length();i<txt.length();i++){
            text[txt.charAt(i)-'a']++;
            text[txt.charAt(i-pat.length())-'a']--;
            if(Arrays.equals(pattern,text)) count++;
        }
        return count;
    }
}