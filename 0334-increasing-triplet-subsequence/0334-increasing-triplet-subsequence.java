class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int x : nums){
            if(x <= firstMin) firstMin = x;
            else if( x <= secondMin) secondMin = x;
            else if( x > secondMin ) return true;
        }
        return false;
    }
}