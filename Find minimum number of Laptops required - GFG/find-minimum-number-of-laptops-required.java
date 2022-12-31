//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    class Pair{
        int start, end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int minLaptops(int N, int[] start, int[] end) {
        Pair[] p = new Pair[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<N;i++){
            p[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(p, (a,b)-> a.start-b.start);
        
        int count = 1, e = p[0].end;
        pq.add(e);
        for(int i=1;i<N;i++){
            if(p[i].start >= pq.peek()){
                pq.poll();
                pq.add(p[i].end);
            } else {
                pq.add(p[i].end);
                count++;
            }
        }
        
        return count;
        
    }
}