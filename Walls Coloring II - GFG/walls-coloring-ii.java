//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    class Pair{
        int val,ind;
        Pair(int val,int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    
	int minCost(int [][] cost) {
		int n = cost.length, k=cost[0].length;
		if(n>=2 && k<2) return -1;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
		for(int i=0;i<k;i++){
		    if(pq.size()==2){
		        if(cost[0][i] < pq.peek().val){
		            pq.poll();
		            pq.add(new Pair(cost[0][i],i));
		        }
		    }else
		        pq.add(new Pair(cost[0][i],i));
		}
		
		for(int i=1;i<n;i++){
		    Pair secondMin = pq.poll();
		    Pair firstMin = pq.poll();
		    for(int j=0;j<k;j++){
		        int currCost = cost[i][j];
		        if(j==firstMin.ind){ //use second min
		            currCost += secondMin.val;
		        }else{ //for all rest use first min
		            currCost += firstMin.val;
		        }
		        
		        if(pq.size()==2){
		            if(currCost < pq.peek().val){
		                pq.poll();
		                pq.add(new Pair(currCost,j));
		            }
		        }else{
		            pq.add(new Pair(currCost,j));
		        }
		    }
		}
		if(pq.size()>=2)
		pq.poll();
		return pq.poll().val;
	}
}