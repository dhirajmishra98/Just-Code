class Solution {
public:
    bool isHappy(int n) {
      int rem,sum=0,temp=n;
        unordered_map<int,int> map;
        while(temp!=1){
            
            while(temp!=0){
                rem = temp%10;
                sum = sum+(rem*rem);
                temp /= 10;
            }
            if(map[sum])
                return false;
            else
                map[sum]++;
            
            temp = sum;
            sum=0;
        }
    
            return true;
    }
};
