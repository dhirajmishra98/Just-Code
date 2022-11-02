class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colorVisited = new int[v];
        
        for(int i=0;i<v;i++){
            if(colorVisited[i] == 0){
                if(!dfs(i,graph,colorVisited,1)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int node, int[][] graph, int[] colorVisited, int color){
        colorVisited[node] = color;
        for(int x : graph[node]){
            if(colorVisited[x] == 0){
                if(!dfs(x,graph,colorVisited,-color)) return false;
            }else if(colorVisited[x] == color) return false;
        }
        return true;
    }
    
}