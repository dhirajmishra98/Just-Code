//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        long ans = 0L;
        long mod = 1000000007;
        int[][] dir = new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                long total = M*N;
                long minus = 1L;
                for(int []dirs : dir){
                    if(valid(i+dirs[0],j+dirs[1],N,M)) minus++;
                }
                
                total -= minus;
                ans = (ans+total)%mod;
            }
        }
        return ans;
    }
    
    static boolean valid(int i, int j, int N, int M){
        return i>=0 && j>=0 && i<N && j<M;
    }
}