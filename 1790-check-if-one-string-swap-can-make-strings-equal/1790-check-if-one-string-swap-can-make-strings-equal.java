class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
          char arr[] = s2.toCharArray();
        char ans[] = s2.toCharArray();
        if(s1.equals(s2))
            return true;
        for(int i=0;i<arr.length;i++){
            int j = i+1;
            while(j<s2.length()){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                String str = new String(arr);
                if(str.equals(s1))
                    return true;
                else{
                    arr[i] = ans[i];
                    arr[j] = ans[j];
                }
                j++;
            }
        }
        return false;
    }
}