class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int res=0;
        for(int i:nums){
            while(!stack.isEmpty() && stack.peek()>i){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()<i){
                res++;
                stack.push(i);
            }
        }
        return res;
    }
}