//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    class Pair{
        int val, index;
        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    void convert(int[] arr, int n) {
        // Pair[] p = new Pair[n];
        // for(int i=0;i<n;i++){
        //     p[i] = new Pair(arr[i],i);
        // }
        
        // Arrays.sort(p, (a,b)->a.val-b.val);
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(temp[i], i);
        }
        
        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
    }
}