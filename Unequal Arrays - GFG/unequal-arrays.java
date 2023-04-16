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
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int n, int[] A, int[] B) {
        long sumA=0,sumB=0,oddA=0,oddB=0;
        
        for(int i=0;i<n;i++){
            sumA += A[i];
            if(A[i]%2!=0) oddA++;
            
            sumB += B[i];
            if(B[i]%2!=0) oddB++;
        }
        
        if(sumA!=sumB || oddA!=oddB) return -1;
        
        ArrayList<Integer> aOdd = new ArrayList<>();
        ArrayList<Integer> bOdd = new ArrayList<>();
        ArrayList<Integer> aEven = new ArrayList<>();
        ArrayList<Integer> bEven = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(A[i]%2==0){
                aEven.add(A[i]);
            }else{
                aOdd.add(A[i]);
            }
            
            if(B[i]%2==0){
                bEven.add(B[i]);
            }else{
                bOdd.add(B[i]);
            }
        }
        
        Collections.sort(aOdd);
        Collections.sort(bOdd);
        Collections.sort(aEven);
        Collections.sort(bEven);
        
        long ans = 0;
        for(int i=0;i<aOdd.size();i++){
            ans += Math.abs(aOdd.get(i)-bOdd.get(i))/2;
        }
        
        for(int i=0;i<aEven.size();i++){
            ans += Math.abs(aEven.get(i)-bEven.get(i))/2;
        }
        
        return ans/2;
        
    }
}
        
