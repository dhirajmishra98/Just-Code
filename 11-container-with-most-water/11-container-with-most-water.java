class Solution {
    public int maxArea(int[] height) {
        int sum = 0;
        int size = height.length;
        
        int front = 0;
        int back = size-1;
        while(front < back){
            int temp = Math.min(height[front],height[back])*(back-front);
            if(temp >= sum){
                sum=temp;
            }
            if(height[front] < height[back]){
                front++;
            } else{
                back--;
            }
        }
        return sum;
    }
}