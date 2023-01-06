//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution
{
    int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        int []prime = new int[10000];
        Arrays.fill(prime,1);
        
        prime[0]=prime[1]=0;
        for(int i=2;i<10000;i++){
            if(prime[i]==1){
                for(int j = 2*i;j<10000;j+=i){
                    prime[j] = 0;
                }
            }
        }
        this.prime = prime;
    }
    
    public int shortestPath(int Num1,int Num2){
        if(Num1 == Num2) return 0;
        
        int[] visited = new int[10000];
        Arrays.fill(visited,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(Num1); visited[Num1] = 0;
        
        while(!q.isEmpty()){
            Integer x = q.poll();
            char []str = Integer.toString(x).toCharArray();
            
            for(int i=0;i<4;i++){
                char[] temp = str.clone();
                int start = i==0?1:0;
                for(int j=start ;j<10; j++){
                    temp[i] = (char) ('0'+j);
                    int k = Integer.valueOf(String.valueOf(temp));
                    if(prime[k]==1 && visited[k]==-1){
                        visited[k] = 1+visited[x];
                        q.add(k);
                    }
                }
            }
        }
        return visited[Num2];
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends