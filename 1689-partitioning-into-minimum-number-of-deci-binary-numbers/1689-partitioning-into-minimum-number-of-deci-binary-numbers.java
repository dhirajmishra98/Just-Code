class Solution {
    public int minPartitions(String n) {
        int maxi = Integer.MIN_VALUE;
     
        for(int i=0;i<n.length();i++){
            int temp = n.charAt(i)-'0';
            maxi = Math.max(temp, maxi);
        }
        return maxi;
    }
}