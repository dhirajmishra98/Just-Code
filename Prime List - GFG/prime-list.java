//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        int []prime = new int[10011];
        Arrays.fill(prime,1);
        
        prime[0]=prime[1]=0;
        for(int i=2;i<10010;i++){
            if(prime[i]==1){
                for(int j = 2*i;j<10010;j+=i){
                    prime[j] = 0;
                }
            }
        }
        this.prime = prime;
    }
    
    Node primeList(Node head){
        Node phead = head;
        while(phead!=null){
            int temp = phead.val;
            if(temp==1) phead.val = 2;
            else if(prime[temp]==0){
                int leftNearestPrime = temp;
                while(prime[leftNearestPrime] == 0){
                    leftNearestPrime --;
                }
                
                int rightNearestPrime = temp;
                while(prime[rightNearestPrime] == 0){
                    rightNearestPrime ++;
                }
                
                int leftdiff = Math.abs(temp-leftNearestPrime);
                int rightdiff = Math.abs(temp-rightNearestPrime);
                
                if(leftdiff <= rightdiff){
                    phead.val = leftNearestPrime;
                }else{
                    phead.val = rightNearestPrime;
                }
            }
            phead = phead.next;
        }
        return head;
        
    }
}