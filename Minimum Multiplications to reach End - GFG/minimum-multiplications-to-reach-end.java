//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int node, step;
        Pair(int node, int step){
            this.node = node;
            this.step = step;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] dist = new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int mod = 100000;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        
        while(!q.isEmpty()){
            int node = q.peek().node;
            int step = q.peek().step;
            q.remove();
            
            for(int x : arr){
                int adjNode = (node*x)%mod;
                if(dist[adjNode] > step+1){
                    dist[adjNode] = step+1;
                    if(adjNode==end) return step+1;
                    q.add(new Pair(adjNode, step+1));
                }
            }
        }
        return -1;
        
    }
}
