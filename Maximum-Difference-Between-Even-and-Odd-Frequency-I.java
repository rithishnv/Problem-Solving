class Solution {
    public int maxDifference(String s) {
        int[] a=new int[26];
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(char i:s.toCharArray()){
            a[i-'a']++;
        }
            for(int i:s.toCharArray()){
            if(a[i-'a']%2==0)
                min=Math.min(min,a[i-'a']);
            else if(a[i-'a']%2!=0 &&a[i-'a']>max)
                max=Math.max(max,a[i-'a']);
        }
        return max-min;
    }
}