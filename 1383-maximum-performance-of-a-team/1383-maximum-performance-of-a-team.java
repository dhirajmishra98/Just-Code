class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i] = new int[]{efficiency[i],speed[i]};
        }
        
        Arrays.sort( arr,(a,b)->Integer.compare(b[0],a[0]) );
        PriorityQueue<Integer> p = new PriorityQueue<>();
        long sum = 0;
        long result = 0;
        
        for(int[] x: arr){
            int spd = x[1];
            p.add(spd);
            if(p.size()<=k) sum += spd;
            else sum += (spd-p.poll());
            
            result = Math.max(result, sum*x[0]);
        }
        return (int)(result % 1000000007);
    }
}