//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int K) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = 0,i=0,j=0;
        char []str = s.toCharArray();
        
        while(j<str.length){
                map.put(str[j],map.getOrDefault(str[j],0)+1);
        
            if(map.size()<K){
               j++;
            }
            if(map.size()==K){
                maxlen = Math.max(maxlen,j-i+1);
                j++;
            }
            if(map.size()>K){
                while(map.size()>K){
                    int freq = map.get(str[i]);
                    if(freq == 1) map.remove(str[i]);
                    else map.put(str[i],freq-1);
                    i++;
                }
                j++;
            }
        }
        return maxlen>0?maxlen:-1;
        
        /*
        //BruteForce : TC=O(N^3), SC=O(N) -> TLE
        int maxlen = 0;
        char []arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                HashSet<Character> set = new HashSet<>();
                for(int k=i;k<=j;k++){
                    set.add(arr[k]);
                }
                if(set.size()==K){
                    maxlen = Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen!=0 ? maxlen : -1;
        */
    }
}