class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        adj = getAdjList(graph);
        // System.out.println(adj);
        
        List<List<Integer>> revAdj = new ArrayList<>();
        int[] indegree = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            revAdj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<adj.size();i++){
            for(Integer it : adj.get(i)){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        // System.out.println(revAdj);
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safe_nodes = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int x = q.peek();
            safe_nodes.add(x);
            q.poll();
            
            for(Integer it : revAdj.get(x)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        
        Collections.sort(safe_nodes);
        return safe_nodes;
    }
    
    private List<List<Integer>> getAdjList(int[][] graph){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        return adj;
    }
}