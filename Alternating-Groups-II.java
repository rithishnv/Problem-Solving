class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n=colors.length;
        int c=0,r=0;
        for(int i=0;i<2*n;i++){
            if(i>0 && colors[i%n]==colors[(i-1)%n])
            c=1;
            else
            c++;
            if(i>=n && c>=k)
            r++;
        }
        return r;
    }
}