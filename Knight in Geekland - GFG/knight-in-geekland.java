//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        int [][]dirs = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        
        int n=arr.length, m=arr[0].length;
        int [][]visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = arr[i][j];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        list.add(visited[start_x][start_y]);
        visited[start_x][start_y] = -1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            int sum = 0;
            for(int k=0;k<sz;k++){
                int x=q.peek()[0];
                int y=q.peek()[1];
                q.poll();
                
                for(int i=0;i<8;i++){
                    int newx = x+dirs[i][0];
                    int newy = y+dirs[i][1];
                    
                    if(newx>=0 && newx<n && newy>=0 && newy<m && visited[newx][newy]!=-1){
                        sum += visited[newx][newy];
                        q.add(new int[]{newx,newy});
                        visited[newx][newy] = -1;
                    }
                }
            }
            list.add(sum);
        }
        
        int lsize = list.size();
        for(int i=lsize-1;i>=0;i--){
            if((list.get(i)+i) < lsize){
                list.set(i, list.get(i)+list.get(i+list.get(i)));
            }
        }
        // System.out.println(list);
        
        int val = Integer.MIN_VALUE, index = -1;
        for(int i=0;i<lsize;i++){
            if(val < list.get(i)){
                val = list.get(i);
                index = i;
            }
        }
        
        
        return index;
    }
}   
