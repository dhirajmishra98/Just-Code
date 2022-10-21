//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        int maxi = Integer.MIN_VALUE,i=0,j=0;
        
        while(j<n){
            p.add(arr[j]);
            if ( (j-i+1)<k ){
                j++;
            } else {
                ans.add(p.peek());
                p.remove(arr[i]);
                i++;
                j++;
            }
        }
        return ans;
        
        /*
        //BruteForce : TC=O(N*K) , SC=O(1)
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<=n-k;i++){
            int temp = Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                if(arr[i+j]>temp) temp = arr[j+i];
            }
            ans.add(temp);
        }
        return ans;
        */
    }
}