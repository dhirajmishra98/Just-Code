//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        char[] s = str.toCharArray();
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(char c : s){
            if(Character.isLowerCase(c)) lower.append(c);
            if(Character.isUpperCase(c)) upper.append(c);
        }
        
        char[] u = upper.toString().toCharArray();
        Arrays.sort(u);
        char[] l = lower.toString().toCharArray();
        Arrays.sort(l);
        
        int i=0,j=0;
        for(char c : s){
            if(Character.isLowerCase(c)){
                result.append(l[i++]);
            } else {
                result.append(u[j++]);
            }
        }
        
        return result.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends