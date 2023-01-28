//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isScramble(String s1,String s2)
    {
        if(s1=="" && s2=="") return true;
        HashMap<String,Boolean> map = new HashMap<>();
        return solve(s1,s2,map);
    }
    
    private static boolean solve(String s1, String s2, HashMap<String,Boolean> map){
        //without memoization gives TLE
        if(s1.equals(s2)) return true;
        if(s1.length() <= 1) return false;
        
        if(map.containsKey(s1+" "+s2)) return map.get(s1+" "+s2);
        
        int n = s1.length();
        for(int i=1;i<n;i++){
            boolean swap = solve(s1.substring(0,i), s2.substring(n-i,n), map) && 
                           solve(s1.substring(i,n), s2.substring(0,n-i), map);
                           
            boolean notswap = solve(s1.substring(0,i), s2.substring(0,i), map) &&
                              solve(s1.substring(i,n), s2.substring(i,n), map);
                              
            if(swap || notswap){
                map.put(s1+" "+s2, true);
                return true;
            } 
        }
        
        map.put(s1+" "+s2, false);
        return false;
    }
}
