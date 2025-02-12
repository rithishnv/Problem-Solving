class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            if(j<popped.length && pushed[i]==popped[j]){
                j++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()==popped[j]){
            stack.pop();
            j++;
            continue;
             }
            stack.push(pushed[i]);
        }
        for(int i=j;i<popped.length;i++){
            if(stack.isEmpty())
            return true;
            if(stack.peek()==popped[i])
            stack.pop();
            else
            return false;
        }
        return true;
    }
}