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
        //Optimized is LIS but TC=O(n2) -> TLE
        
        //LIS with Binary Search (intuition from striver's video) : TC=O(NlogN), SC=O(N)
        ArrayList<Integer> arr = new ArrayList<>();
        int len = 1;
        arr.add(H[0]);
        
        for(int i=1;i<N;i++){
            if(H[i] > arr.get(arr.size()-1)){
                arr.add(H[i]);
                len++;
            } else {
                int index = binarySearch(arr,H[i],0,arr.size());
                arr.set(index,H[i]); 
            }
        }
        return N-len;
    }
    
    private int binarySearch(ArrayList<Integer> array, int key, int low, int high){
        while (low < high) {
            int mid = low + (high - low) / 2;
 
            if (key <= array.get(mid)) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        
        if (low < array.size() && array.get(low) < key) {
            low++;
        }
        return low;
    }
};