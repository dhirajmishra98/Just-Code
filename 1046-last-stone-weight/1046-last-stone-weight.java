class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        
        while(pq.size()>0){
            if(pq.size() == 1){
                return pq.poll();
            } 
            int f = pq.poll();
            int s = pq.poll();
            
            if(f!=s){
                pq.add(Math.abs(f-s));
            }
        }
        return 0;
    }
}