class Solution {
 
    public int helper(int num, int count){
        if(num == 0)
            return count;
        if(num%2 == 0){
            return helper(num/2, ++count);
        } else {
            return helper(--num,++count);
        }
    }
    // int count = 0;
    public int numberOfSteps(int num) {
        
        return helper(num,0);
        //  if(num == 0)
        //     return count;
        // if(num%2 == 0){
        //     ++count;
        //     return numberOfSteps(num/2);
        // } else {
        //     ++count;
        //     return numberOfSteps(--num);
        // }
    }

}