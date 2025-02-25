class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=0,i=0;
        Stack<Integer> stack=new Stack<>();
        while(i<heights.length){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
                stack.push(i++);
            }
            else{
                int h=stack.pop();
                int w=(stack.isEmpty())?i:i-stack.peek()-1;
                area=Math.max(area,heights[h]*w);
            }
        }
        while(!stack.isEmpty()){
            int h=stack.pop();
                int w=(stack.isEmpty())?i:i-stack.peek()-1;
                area=Math.max(area,heights[h]*w);
        }
        return area;
    }
}