class Solution {
    public int maxDiff(int num) {
         String sb=String.valueOf(num);
        int min=num;
        int max=num;
        int n=sb.length();
        int pos=0;
        while(pos<n && sb.charAt(pos)=='9'){
            pos++;
        }
        if(pos<n)
        max=Integer.parseInt(sb.replace(sb.charAt(pos),'9'));
        pos=0;
        if(sb.charAt(0)>'1')
        min=Integer.parseInt(sb.replace(sb.charAt(0),'1'));
        else{
        while(pos<n && (sb.charAt(pos)=='0'||sb.charAt(pos)=='1')){
        pos++;
        }
        if(pos<n)
        min=Integer.parseInt(sb.replace(sb.charAt(pos),'0'));
        }
        
        return max-min;
    }
}