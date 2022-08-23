class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int h2 = i*i + j*j;
                double h1 = Math.sqrt(h2);
                // if(h1*h1 == h2 && h1<=n){
                //     ans = ans + 2;
                // }
                if(h1%1==0 && h1<=n){
                    ans = ans + 2;
                }
            }
        }
        return ans;
    }
}