class Solution {
    public int maxArea(int[] height) {
        int max=0,i=0,j=height.length-1;
       while(i<j){
        if(height[i]>=height[j]){
            max=Math.max(max,height[j]*(j-i));
            j--;
        }
        else{
            max=Math.max(max,height[i]*(j-i));
            i++;
        }
       }
        return max;
    }
}