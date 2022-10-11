class Solution {
    public int numberOfBeams(String[] bank) {
        int count = 0;
        int prev = countOnes(bank[0]);
        for(int i=1;i<bank.length;i++){
            int temp = countOnes(bank[i]);
            if(temp != 0){
                count += (prev*temp);
                prev = temp;
            }
        }
        return count;
    }
    
    private static int countOnes(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') count++;
        }
        return count;
    }
}