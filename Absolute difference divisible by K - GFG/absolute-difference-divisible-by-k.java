//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static long countPairs(int n, int[] arr, int k) {
	    /*
	    //Bruteforce : TC=O(n2), SC=O(1) -> TLE
		long count = 0;
		for(int i=0;i<n;i++){
		    for(int j=i+1;j<n;j++){
		        if(Math.abs(arr[i]-arr[j])%k == 0) count++;
		    }
		}
		return count;
		*/
		
		int []remTable = new int[k];
		for(int x : arr) remTable[x%k]++;
		
		long ans = 0;
		for(int x : remTable){
		    ans += (x*(x-1))/2;
		}
		return ans;
	}
}