class Solution {
    public boolean checkInclusion(String s1, String s2) {
         HashMap<Character,Integer> map1 = new HashMap<>();
        char []str1 = s1.toCharArray();
        char []str2 = s2.toCharArray();
        
        for(char x : str1)
            map1.put(x,map1.getOrDefault(x,0)+1);
        
        HashMap<Character,Integer> map2 = new HashMap<>();
        int i=0,j=0;
        while(j<str2.length){
            map2.put(str2[j], map2.getOrDefault(str2[j],0)+1);
            if(j<str1.length-1){
                j++;
            } else if(j-i+1 == str1.length){
                if(map1.equals(map2)) return true;
                int freq = map2.get(str2[i]);
                if(freq == 1) map2.remove(str2[i]);
                else map2.put(str2[i],freq-1);
                i++;
                j++;
            }else {
                j++;
            }
        }
        return false;
        
        /*
        //BruteForce : TC=O(s2.length), SC=O(s1.length + s2.length) -> TLE
        HashMap<Character,Integer> map1 = new HashMap<>();
        char []str1 = s1.toCharArray();
        char []str2 = s2.toCharArray();
        
        for(char x : str1)
            map1.put(x,map1.getOrDefault(x,0)+1);
        
        for(int i=0;i<str2.length;i++){
            for(int j=i;j<str2.length;j++){
                HashMap<Character,Integer> map2 = new HashMap<>();
                for(int k=i;k<=j;k++){
                    map2.put(str2[k], map2.getOrDefault(str2[k],0)+1);
                }
                if(map1.equals(map2)) return true;
            }
        }
        return false;
        */
    }
}