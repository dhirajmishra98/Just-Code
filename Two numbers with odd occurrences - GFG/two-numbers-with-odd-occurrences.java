//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(Arr[i], map.getOrDefault(Arr[i],0)+1);
        }
        
        int[] ans = new int[2];
        int k=0;
        for(int i=0;i<N;i++){
            if(map.get(Arr[i])%2!=0){
                if(k==1){
                    if(ans[0] != Arr[i]){
                        ans[1] = Arr[i];
                        break;
                    }
                } else{
                    ans[0] = Arr[i];
                k++;
                }
                
            }
        }
        
        if(ans[0] < ans[1]){
            int temp = ans[0];
            ans[0]  = ans[1];
            ans[1] = temp;
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }
}