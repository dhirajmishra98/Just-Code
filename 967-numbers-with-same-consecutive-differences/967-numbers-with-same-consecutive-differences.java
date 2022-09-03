class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if(n==1)
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(n,k,i,i,1,res);
        }
        
        int []ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    private void dfs(int n, int k, int currNum, int prevPointer,int countDigits, ArrayList<Integer> res){
        
        if(countDigits == n){
            res.add(currNum);
            return;
        }
        
        int addedK = prevPointer+k;
        if(addedK <= 9){
            dfs(n,k,(currNum*10)+addedK, addedK, countDigits+1,res);
        }
        
        addedK= prevPointer-k;
        if(k!=0 && addedK>=0 ){
            dfs(n,k,(currNum*10)+addedK, addedK, countDigits+1, res);
        }
    }
}