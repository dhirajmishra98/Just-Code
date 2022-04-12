class Solution {
    public int addDigits(int num) {
//         int ans;
//        if(num%9 == 0)
//            ans = 9;
//         else if(num==0)
//             ans = 0;
//         else
//             ans = num%9;
        
//         return ans;
        if ( num == 0 ) return 0;
	return num%9 == 0 ? 9 : num%9 ;
    }
    
}