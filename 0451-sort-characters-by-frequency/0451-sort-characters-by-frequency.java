class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->b.getValue()-a.getValue());
        
       pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry m = pq.poll();
            for(int i=0;i<(int)m.getValue();i++){
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }
    
}