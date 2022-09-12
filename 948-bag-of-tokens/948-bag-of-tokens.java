class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0) return 0;
        
        Arrays.sort(tokens);
        int start = 0, end = tokens.length-1, score = 0;
        while(start<=end){
            if(tokens[start]<=power){
                power -= tokens[start];
                score++;
                start++;
            } 
            
             else{
                if(score>0 && start<end){
                    power += tokens[end];
                score--;
                end--;
             } else{
                    break;
                }
            } 
        }
        return score;
    }
}