//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0,j=0,m=S.length(),n=T.length();
        while(i<m && j<n){
            if(Character.isDigit(T.charAt(j))){
                int count = 0;
                while(j<n && Character.isDigit(T.charAt(j))){
                    count = count*10+(int)(T.charAt(j)-'0');
                    j++;
                }
                i += count;
            }else{
                if(S.charAt(i)==T.charAt(j)){
                    i++;
                    j++;
                }else {
                    return 0;
                }
            }
        }
        return (i==m && j==n)?1:0;
    }
}