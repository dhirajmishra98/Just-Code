for sorting lambda function is used
(arr, (a,b)->a-b)
this means any two elements of arr is passed to a function as (a,b) if its result is a-b as
-1, it means a is left of b (ascending)
0, it means a==b, a and b position will remain same
1, it means , a is right of b (descending)
​
​
/*********
In this case a - b returns
a negative number if a is smaller than b – so a will be sorted to the left of b
a positive number if a is bigger than b – so a will be sorted to the right of b
zero if they are equal – so it doesn’t matter which one comes first
If you wanted to sort in descending order, i.e. bigger numbers first, you’d need your function to return b - a to invert the logic.
*************/
​
​
we have used this lambda function in pair to sort according to weak soldier number to high, along with this indexes are also changed accordingly and we store these indexes and return the resultant array.