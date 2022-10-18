class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int i=0,j=0,d=0;
        while(i<nums1.length && j<nums2.length){
            if(i<=j && nums1[i]<=nums2[j]){
                d=Math.max(d,j-i);
                j++;
                
            } else if(nums1[i] > nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return d;
        
        /*
        //BruteForce Approach : TC=O(m*n) , SC=O(1) -> TLE
        int d = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(i<=j && nums1[i]<=nums2[j]){
                    d = Math.max(d,j-i);
                }
            }
        }
        return d;
        */
    }
}