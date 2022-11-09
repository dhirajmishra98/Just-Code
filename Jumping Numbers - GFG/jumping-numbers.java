//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        /*
        //Bruteforce -> TLE
        if(X/10 == 0) return X;
        for(long i=X;i>=0;i--){
            if(jumping(i)) return i;
        }
        return -1;
        */
        
        // Graph BFS
        Queue<Long> q = new LinkedList<>();
        for(long i=1;i<=9 && i<=X;i++){
            q.add(i);
        }
        long ans = 0L;
        while(!q.isEmpty()){
            long num = q.poll();
            if(num <= X){
                ans = Math.max(num,ans);
                long lastDigit = num%10;
                if(lastDigit == 0){
                    q.add(num*10 + (lastDigit+1));
                } else if(lastDigit==9){
                    q.add(num*10 + (lastDigit-1));
                } else{
                    q.add(num*10 + (lastDigit+1));
                    q.add(num*10 + (lastDigit-1));
                }
            }
        }
        return ans;
    }
    
    private static boolean jumping(long n){
        long temp = n%10;
        n = n/10;
        while(n>0){
            long rem = n%10;
            if(Math.abs(rem-temp)==1){
                temp = rem;
                n = n/10;
            } else{
                return false;
            }
        }
        return true;
    }
};