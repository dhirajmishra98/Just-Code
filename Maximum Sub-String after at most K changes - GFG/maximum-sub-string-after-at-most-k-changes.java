//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int i=0,j=0,max_occurence=0, ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            max_occurence = Math.max(map.get(s.charAt(j)), max_occurence);
            
            int size = (j-i+1);
            if(size-max_occurence > k){
                int freq = map.get(s.charAt(i));
                if(freq == 1) map.remove(s.charAt(i));
                else map.put(s.charAt(i), freq-1);
                i++;
            } 
            else
                ans = Math.max(ans,size);
            j++;
        }
        return ans;
    }
}