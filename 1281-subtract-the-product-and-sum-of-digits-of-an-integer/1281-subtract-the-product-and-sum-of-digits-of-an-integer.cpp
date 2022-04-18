class Solution {
public:
    int subtractProductAndSum(int n) {
        int add=0,mul=1;
        while(n>0){
            int rem = n%10;
            add = add+rem;
            mul = mul*rem;
            n /= 10;
        }
        return mul-add;
    }
};