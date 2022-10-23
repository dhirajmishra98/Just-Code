class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int maxsize = Math.max(g.length,s.length);
        
        int i=0,j=0,count=0;
        while(j<s.length && i<g.length){
            if(g[i]<=s[j]) {
                count++;
                i++;
                j++;
            }
            else if(g[i]>s[j]) {
                j++;
            }
        }
        return count;
    }
}