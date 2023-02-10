//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char x : s.toCharArray()){
            if(x=='b' || x=='a' || x=='l' || x=='o' || x=='n')
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        if(map.size() < 5) return 0;
        int maxi = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getKey() == 'l' || e.getKey()=='o'){
                maxi = Math.min(maxi,e.getValue()/2);
            }else{
                maxi = Math.min(maxi,e.getValue());
            }
        }
        
        return maxi;
    }
}