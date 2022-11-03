//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<dict.length-1;i++){
            char[] str1 = dict[i].toCharArray();
            char[] str2 = dict[i+1].toCharArray();
            for(int j=0;j<Math.min(str1.length,str2.length);j++){
                if(str1[j]!=str2[j] ){
                    adj.get(str1[j]-'a').add(str2[j]-'a');
                    break;
                }
            }
        }
        
        int[] indegree = new int[K];
        for(int i=0;i<K;i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int x = q.poll();
            str.append(String.valueOf((char)(x+'a')));
            for(Integer it : adj.get(x)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        // System.out.println(str);
        return str.toString();
    }
}

/*
//rough work - personally tried
Stack<Character> s = new Stack<>();
        for(int i=0;i<dict.length-1;i++){
            char[] str1 = dict[i].toCharArray();
            char[] str2 = dict[i+1].toCharArray();
            for(int j=0;j<Math.min(str1.length,str2.length);j++){
                if(str1[j]!=str2[j] && !s.contains(str1[j])){
                    s.push(str1[j]);
                    break;
                }
            }
        }
        
        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()){
            str.append(s.pop());
        }
       
        String order = str.reverse().toString();
        for(int ch = 0;ch<=122;ch++){
            if(!order.contains(String.valueOf((char)(ch+97)))){
                order = order+String.valueOf((char)(ch+97));
                break;
            }
        }
         System.out.println(order);
        
        return order;
        
        */
        