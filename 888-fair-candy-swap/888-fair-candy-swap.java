class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA =0, sumB=0;
        Set<Integer> setB = new HashSet<>();
        
        for(int x : aliceSizes)
            sumA+=x;
        
        for(int x : bobSizes){
            setB.add(x);
            sumB+=x;
        }
        
        int avgCandies = (sumB-sumA)/2;
        
        for(int x : aliceSizes){
            if(setB.contains(x+avgCandies)){
                return new int[]{x,x+avgCandies};
            }
        } 
        return null;
    }
}