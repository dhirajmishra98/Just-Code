class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int d = 0;
        for(int i=0;i<nums1.length;i++){
            int start = i;
            int end = nums2.length-1;
            while(start <= end){
                int mid = start +  (end-start)/2;
                if(nums1[i] <= nums2[mid]){
                    d = Math.max(d,mid-i);
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return d;
        
        /*
        //Two Pointers Approach : TC=O(min(m,n)), SC=O(1)
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
        */
        
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