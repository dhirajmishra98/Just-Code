//INT_MAX
Because , INT_MAX = 2147483647
INT_MAX/10 = 214748364
So, if reverse > 214748364, say 214748365
then definitely reverse*10 (2147483650) is overflowing
Also, if reverse = INT_MAX/10 = 214748364
Then reverse*10 = 2147483640
But then pop must be <= 7 to avoid overflow
​
//INT_MIN
​
Because , INT_MIN = -2147483648
INT_MIN/10 = -214748364
So, if reverse < -214748364, say -214748365
then definitely reverse*10 (-2147483650) is overflowing
Also, if reverse = INT_MIN/10 = -214748364
Then  reverse*10 = -2147483640
But then remain must be >= -8 (i.e. -8, -7, -6, -5 etc) to avoid overflow
Adding those to -2147483640 will not go beyond INT_MIN limit