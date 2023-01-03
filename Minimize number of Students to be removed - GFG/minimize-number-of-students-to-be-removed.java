//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.removeStudents(H,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        int len = 1;
        arr.add(H[0]);
        
        for(int i=1;i<N;i++){
            if(H[i] > arr.get(arr.size()-1)){
                arr.add(H[i]);
                len++;
            } else {
                // int n = arr.size();
                // int [] array = new int[n];
                // for(int j=0;j<n;j++){
                //     array[j] = arr.get(j);
                // }
                // int index = lower_bound(array,H[i]);
                int index = binarySearch(arr,H[i],0,arr.size());
                arr.set(index,H[i]); 
            }
        }
        return N-len;
    }
    
    private int binarySearch(ArrayList<Integer> array, int key, int low, int high){
        int mid;
        while (low < high) {
 
            // Find the index of the middle element
            mid = low + (high - low) / 2;
 
            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array.get(mid)) {
                high = mid;
            }
 
            // If key is greater than array[mid],
            // then find in right subarray
            else {
 
                low = mid + 1;
            }
        }
 
        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.size() && array.get(low) < key) {
            low++;
        }
 
        // Returning the lower_bound index
        return low;
    }
    
    
 
};