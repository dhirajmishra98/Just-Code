class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        
        
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a,b)->(a.getValue()==b.getValue()
                                                                    ?(a.getKey().compareToIgnoreCase(b.getKey()))
                                                                    :b.getValue()-a.getValue()));
        
        System.out.println(q);
        
        for(Map.Entry<String,Integer> e : map.entrySet()){
            q.add(e);
        }
        
        List<String> l = new ArrayList<>();
        while(k > 0){
            l.add(q.poll().getKey());
            k--;
        }
        
        return l;
    }
}