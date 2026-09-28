class Solution {
    public int maxDepth(String s) {
        int max=0;
        int t=0;
        for(char i:s.toCharArray()){
            if(i=='(')
            t++;
            else if(i==')'){
                max=Math.max(t,max);
                t--;
            }
        }
        return max;
    }
}