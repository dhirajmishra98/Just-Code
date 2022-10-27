//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = 0,i=0,j=0;
        char []str = S.toCharArray();
        
        while(j<str.length){
            map.put(str[j],map.getOrDefault(str[j],0)+1);
            if(map.size() == (j-i+1)){
                maxlen = Math.max(maxlen, j-i+1);
                j++;
            }
            else if(map.size() < (j-i+1)){
                while(map.size() < (j-i+1)){
                    int freq = map.get(str[i]);
                    if(freq == 1) map.remove(str[i]);
                    else map.put(str[i],freq-1);
                    i++;
                }
                j++;
            }
        }
        return maxlen;
        
        /*
        //BruteForce : TC=O(N^3), SC=O(N) -> TLE
        int maxlen = 0;
        char []str = S.toCharArray();
        for(int i=0;i<str.length;i++){
            for(int j=i;j<str.length;j++){
                HashMap<Character,Integer> map = new HashMap<>();
                for(int k=i;k<=j;k++){
                    map.put(str[k],map.getOrDefault(str[k],0)+1);
                }
                if((j-i+1)==map.size())
                maxlen = Math.max(maxlen,map.size());
            }
        }
        return maxlen;
        */
    }
}