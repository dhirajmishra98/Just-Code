//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        if(n==1) return arr[0];
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        HashSet<String> set = new HashSet<>();
        
        for(String x : arr) set.add(x);
        //  System.out.println(set);
        
        String ans = "";
        for(int i=arr.length-1;i>=0;i--){
            int index=0, count = 0;
            // System.out.println(arr[i].substring(0,index));
            while(index<arr[i].length() && set.contains(arr[i].substring(0,index+1))){
                // System.out.println(index);
                // System.out.println(arr[i].substring(0,index+1));
                index++;
                count++;
            }
            
            if(count == arr[i].length() && arr[i].length()>=ans.length()) ans = arr[i];
            // System.out.println(ans);
        }
        return ans;
    }
}
        
