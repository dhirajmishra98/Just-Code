//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countSubarray(int N, int A[], int M) 
    { 
        // code here
        // We need to find the count of subarrays where the sum of elements is greater than or equal to M.
    // We can use a sliding window approach to count the number of subarrays with sum >= M for each possible starting index.
    // Then, we can subtract the count of subarrays with sum >= M+1 from the count of subarrays with sum >= M to get the answer.
    
    // We use the getSubarrayCount() function to count the number of subarrays with sum >= M and M+1.
    return getSubarrayCount(N, A, M) - getSubarrayCount(N, A, M + 1);
}
    
public static long getSubarrayCount(int n, int[] arr, int m) {
    // We keep track of the frequency of each possible cumulative sum of the array.
    // The cumulative sum at index i is the sum of all elements from 0 to i.
    // We use an array called freq to store the frequency of each possible cumulative sum.
    int[] freq = new int[2 * n + 1];
    
    // We start with a cumulative sum of n, since the sum of an empty array is 0.
    long total = 0, count = 0;
    int curSum = n;
    freq[curSum]++;
    
    // We iterate through the array and update the cumulative sum and frequency array.
    for (int i = 0; i < n; i++) {
        // We calculate the difference in the cumulative sum if we add the current element.
        int diff = -1;
        if (arr[i] >= m) {
            diff = 1;
        }
        
        // If the difference is negative, we need to subtract the frequency of the cumulative sum that is diff away.
        // If the difference is positive, we need to add the frequency of the current cumulative sum to the total count.
        if (diff == -1) {
            total -= freq[(curSum + diff)];
        } else {
            total += freq[curSum];
        }
        
        // We update the current cumulative sum and frequency array.
        curSum += diff;
        count += total;
        freq[curSum]++;
    }
    
    // We return the count of subarrays with sum >= m.
    return count;
    }
} 