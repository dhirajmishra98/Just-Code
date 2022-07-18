import java.util.*;

class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double total = 0.0;
        for (int m : salary){
            total += m;
        }
        total = total - salary[0] - salary[salary.length-1];
        return (total / (salary.length-2));
    }
}