class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++) q.offer(i);
        
        int  temp = k;
        while(q.size()>1){
            k--;
            if(k==0){
                q.remove();
                k = temp;
            } else {
                // int d = q.poll();
                q.offer(q.poll());
                
            }
        }
        return q.poll();
    }
}