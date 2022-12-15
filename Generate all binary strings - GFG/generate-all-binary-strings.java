//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
      List<String> ans = new ArrayList<>();
      generator("",0,n,ans);
      return ans;
  }
  
  private static void generator(String str,int x, int n, List<String> ans){
      if(n==x){
          ans.add(str);
          return;
      }
      
      generator(str+'0',x+1,n,ans);
      if(x>0 && str.charAt(x-1)=='1') return;
      generator(str+'1',x+1,n,ans);
  }
}
     
     