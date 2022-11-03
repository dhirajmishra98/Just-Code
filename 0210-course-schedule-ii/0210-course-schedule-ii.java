class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int x = q.peek();
            topo.add(x);
            q.poll();
            for(int it : adj.get(x)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        
        int[] ans = new int[topo.size()];
        for(int i=0;i<topo.size();i++){
            ans[i] = topo.get(i);
        }
        
        if(ans.length == numCourses) return ans;
        return new int[]{};
    }
}