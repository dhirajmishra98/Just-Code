//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
        
        char[] str = S.toCharArray();
        for(int i=0;i<N;i++){
            if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
                vowels.append(str[i]);
            } else {
                consonants.append(str[i]);
            }
        }
        
        if(Math.abs(vowels.length()-consonants.length()) > 1) return "-1";
        char []v = vowels.toString().toCharArray();
        char []c = consonants.toString().toCharArray();
        Arrays.sort(v);
        Arrays.sort(c);
        
        if(v.length > c.length){
            StringBuilder ans = new StringBuilder();
            int k=0;
            for(int i=0;i<v.length;i++){
                ans.append(v[i]);
                if(i<v.length-1){
                    ans.append(c[k]);
                    k++;
                }
            }
            return ans.toString();
        }
        else if(v.length == c.length){
            StringBuilder ans = new StringBuilder();
            int k=0;
            for(int i=0;i<v.length;i++){
                ans.append(v[i]);
                if(i<v.length){
                    ans.append(c[k]);
                    k++;
                }
            }
            return ans.toString();
        } else {
            StringBuilder ans = new StringBuilder();
            int k=0;
            for(int i=0;i<c.length;i++){
                ans.append(c[i]);
                if(i<c.length-1){
                    ans.append(v[k]);
                    k++;
                }
            }
            return ans.toString();
        }
    }
}