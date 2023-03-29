//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        //TC=O(N2), SC=O(1) -> Checking all possible substring
        int count = 0;
        for(int i=0;i<S.length();i++){
            int l=0,u=0;
            for(int j=i;j<S.length();j++){
                // // System.out.println(S.substring(i,j));
                // if(isValid(S.substring(i,j))) count++;
                
                if(Character.isUpperCase(S.charAt(j))) u++;
                else if(Character.isLowerCase(S.charAt(j))) l++;
                if(u==l) count++;
            }
        }
        
        return count;
    }
    
    // private boolean isValid(String str){
    //     int upper=0, lower=0;
    //     for(char x : str.toCharArray()){
    //         if(Character.isUpperCase(x)) upper++;
    //         else if(Character.isLowerCase(x)) lower++;
    //     }
        
    //     return upper==lower?true:false;
    // }
    
} 
