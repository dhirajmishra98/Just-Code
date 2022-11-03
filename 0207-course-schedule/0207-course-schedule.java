class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int count = 0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int x = q.poll();
            count++;
            for(int it : adj.get(x)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }
}