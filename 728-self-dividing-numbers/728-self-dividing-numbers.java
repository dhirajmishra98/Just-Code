class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(solve(i)){
                arr.add(i);
            }
        }
        return arr;
    }
    
    static boolean solve(int n){
        boolean flag = true;
        int temp = n;
        while(n>0){
            int rem = n%10;
            if(rem==0){
                return false;
            }
            if(temp%rem != 0){
               return false;
            }
            n = n/10;
        }
         return flag;
    }
}