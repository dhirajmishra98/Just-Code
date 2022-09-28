Intution behind the DP solution of this problem rises from the fact that the difference in the number of set bits of a number and (number/2) if always less than or equal to 1 i.e
​
if x/2 = y
then  Number of set bits in (x) - Number of set bits in (y) <= 1
For eg let us consider x = 5, then y = (5/2) = 2
​
Binary Reprsentation of x = 5 = 101 (No. of set bits = 2)
Binary Reprsentation of y = 2 = 010 (No. of set bits = 1)
​
So the difference in set bits is 1.
​
Now lets consider x = 6, then y=(6/2) = 3
​
Binary Reprsentation of x = 6 = 110 (No. of set bits = 2)
Binary Reprsentation of y = 3 = 011 (No. of set bits = 2)
​
So the difference in set bits is 0.
​
Thus we can say that -->
​
1. If x is even then the number of set bits in x will be equal to the number of set bits in (x/2).
2. If x is odd then the number of set bits in x will be equal to the number of set bits in (x/2) + 1.
​
This is because while dividing number by 2 we are basically doing right shift of the number by 1.
​
If the number x is odd then its last bit will be 1 which will get lost while doing the right shift (or dividing by 2) so to consider the last set bit we add additional 1 .
In case if x is even then the last bit will always be 0 and if it gets lost while doing the right shift we don't care since it was 0.