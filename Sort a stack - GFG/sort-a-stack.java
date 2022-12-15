//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> sorted = new Stack<>();
		while(!s.isEmpty()){
		    int temp = s.pop();
		    sortedInsert(sorted,temp);
		}
		return sorted;
	}
	
	private void sortedInsert(Stack<Integer> sorted, int x){
	    if(sorted.isEmpty()) sorted.push(x);
	    
	    else if(sorted.peek() <= x) sorted.push(x);
	    else {
	        int temp = sorted.pop();
	        sortedInsert(sorted,x);
	        sorted.push(temp);
	    }
	}
}