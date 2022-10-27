//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //initial sum=0, at index=-1
        int sum = 0,maxlen=0;
        
        for(int i=0;i<N;i++){
            sum += A[i];
            if(map.containsKey(sum-K)){
                maxlen = Math.max(maxlen, i-map.get(sum-K));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxlen;
        
        /*
        //Bruteforce : TC=O(N^3), SC=O(1) -> TLE
        int longest=0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += A[k];
                }
                if(sum==K){
                        longest = Math.max(longest,j-i+1);
                    }
            }
        }
        return longest;
        */
        
        /*
        //This will work only for array with positive number 
        int sum=0,i=0,j=0,maxlen=0;
        while(j<N){
            sum = sum+A[j];
            if(sum < K){
                j++;
            } else if(sum==K){
                maxlen = Math.max(maxlen,(j-i+1));
                j++;
            }else {
                while(sum > K){
                    sum = sum-A[i];
                    i++;
                }
                j++;
            }
        }
        return maxlen;
        */
    }
    
    
}


