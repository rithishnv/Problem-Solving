class Solution {
    public int minMaxDifference(int num) {
        String sb=String.valueOf(num);
        int min=Integer.MAX_VALUE;
        int max=num;
        int n=sb.length();
        int pos=0;
        while(pos<n && sb.charAt(pos)=='9'){
            pos++;
        }
        min=Integer.parseInt(sb.replace(sb.charAt(0),'0'));
        if(pos<n)
        max=Integer.parseInt(sb.replace(sb.charAt(pos),'9'));
        return max-min;
    }
}