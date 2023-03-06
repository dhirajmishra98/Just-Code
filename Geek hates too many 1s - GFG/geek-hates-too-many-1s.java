//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        char []binary = new StringBuilder(Integer.toBinaryString(n)).reverse().toString().toCharArray();
        // System.out.println(Arrays.toString(binary));
        int ans =0, check = 0;
        
        for(int i=binary.length-1;i>=0;i--){
            if(binary[i]=='1'){
                check++;
                if(check < 3) ans += Math.pow(2,i);
                else check = 0;
            }else{
                check = 0;
            }
        }
        return ans;
    }
}
        
