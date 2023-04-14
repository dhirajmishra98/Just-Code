//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    class Pair{
        int c,r;
        Pair(int c, int r){
            this.c = c;
            this.r = r;
        }
    }
    
    public int finLength(int N, int[] color, int[] radius) {
        Pair []p = new Pair[N];
        for(int i=0;i<N;i++){
            p[i] =  new Pair(color[i],radius[i]);
        }
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(color[0],radius[0]));
        
        for(int i=1;i<N;i++){
            if(!st.isEmpty() && st.peek().c == color[i] && st.peek().r == radius[i]){
                st.pop();
            }else{
                st.push(new Pair(color[i],radius[i]));
            }
        }
        
        return st.size();
    }
}
        
