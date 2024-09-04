class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            int f=0;
            while(!stack.isEmpty() &&stack.peek()>0&&asteroids[i]<0){
                int m=stack.pop();
                if(Math.abs(m)>Math.abs(asteroids[i])){
                stack.push(m);
                f=1;
                break;
                }
                else if(Math.abs(m)==Math.abs(asteroids[i])){
                    f=1;
                    break;
                }
            }
            if(f==0)
            stack.push(asteroids[i]);
        }
        int n=stack.size();
        int[] a=new int[n];
        n-=1;
        while(!stack.isEmpty()){
            a[n--]=stack.pop();
        }
        return a;
    }
}