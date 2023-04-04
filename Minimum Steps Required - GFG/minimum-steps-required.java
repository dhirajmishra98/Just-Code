//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
		int ansA = 0;
		boolean containsB = false,Wr = false;
		for(int i=0;i<str.length();i++){
		    if(str.charAt(i)=='a'){
		        ansA++;
		        while(i<str.length() && str.charAt(i)=='a') {i++; Wr=true;}
		        if(Wr) {i--; Wr=false;}
		    }else{
		        containsB = true;
		    }
		}
		if(containsB) ansA+=1;
		
		int ansB = 0;
		boolean containsA = false,  wR = false;
		for(int i=0;i<str.length();i++){
		    if(str.charAt(i)=='b'){
		        ansB++;
		        while(i<str.length() && str.charAt(i)=='b') {i++; wR=true;}
		        if(wR) {i--; wR=false;}
		    }else{
		        containsA = true;
		    }
		}
		
		
		if(containsA) ansB+=1;
		
		return Math.min(ansA,ansB);
		
	}
}