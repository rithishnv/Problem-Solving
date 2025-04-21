class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
       long s=0,min=0,max=0;
       for(int i:differences){
        s+=i;
        min=Math.min(min,s);
        max=Math.max(max,s);
       }
       return (int)Math.max(0,(upper-max)-(lower-min)+1);
    }
}