class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int l=0,max=0,sum=0;
        for(int r=0;r<fruits.length;r++){
            sum+=fruits[r][1];
            while(l<=r && minStep(fruits[l][0],fruits[r][0],startPos)>k){
                sum-=fruits[l][1];
                l++;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
    public int minStep(int l,int r,int s){
        int left=Math.abs(s-l)+(r-l);
        int right=Math.abs(s-r)+(r-l);
        return Math.min(left,right);
    }
}